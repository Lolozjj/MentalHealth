package com.mju.zjj.gateway.utils;

/**
 * @author ：zhengjunjie
 * @date ：Created in 2021/3/22 14:54
 * @description：
 * @modified By：
 * @version: 1.0.0
 */

import com.mju.zjj.common.entity.GatewayLog;
import com.mju.zjj.gateway.feign.GatewayLogFeign;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ${DESCRIPTION}
 *
 * @author the sun
 * @create 2017-07-01 15:28
 */
@Slf4j
public class DBLog extends Thread {
    private static DBLog dblog = null;
    private static BlockingQueue<GatewayLog> logInfoQueue = new LinkedBlockingQueue<GatewayLog>(1024);

    public GatewayLogFeign getLogService() {
        return logService;
    }

    public DBLog setLogService(GatewayLogFeign logService) {
        if(this.logService==null) {
            this.logService = logService;
        }
        return this;
    }

    private GatewayLogFeign logService;
    public static synchronized DBLog getInstance() {
        if (dblog == null) {
            dblog = new DBLog();
        }
        return dblog;
    }

    private DBLog() {
        super("CLogOracleWriterThread");
    }

    public void offerQueue(GatewayLog logInfo) {
        try {
            logInfoQueue.offer(logInfo);
        } catch (Exception e) {
            log.error("日志写入失败", e);
        }
    }

    @Override
    public void run() {
        List<GatewayLog> bufferedLogList = new ArrayList<GatewayLog>();
        while (true) {
            try {
                bufferedLogList.add(logInfoQueue.take());
                logInfoQueue.drainTo(bufferedLogList);
                if (bufferedLogList != null && bufferedLogList.size() > 0) {
                    // 写入日志
                    for(GatewayLog log:bufferedLogList){
                        logService.add(log);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // 防止缓冲队列填充数据出现异常时不断刷屏
                try {
                    Thread.sleep(1000);
                } catch (Exception eee) {
                }
            } finally {
                if (bufferedLogList != null && bufferedLogList.size() > 0) {
                    try {
                        bufferedLogList.clear();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}