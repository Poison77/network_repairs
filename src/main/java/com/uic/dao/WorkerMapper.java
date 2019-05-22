package com.uic.dao;

import com.uic.pojo.Worker;

import java.util.List;

/**
 * 职工基本信息管理
 */
public interface WorkerMapper {
    /**
     * 遍历
     */
    public List<Worker> queryWorker()throws Exception;

    /**
     * 根据职工id查找职工信息
     */
    public Worker findWorkerByWorkerId(String workerId)throws Exception;

    /**
     * 根据职工id修改职工信息
     */
    public void updateWorkerByWorkerId(Worker worker) throws Exception;

    /**
     * 插入职工
     */
    public void insertOrUpdateWorker(Worker worker)throws Exception;

    /**
     * 逻辑删除职工信息
     */
    public void deleteWorkerByWorkerId(String workerId) throws Exception;
}
