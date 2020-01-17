package com.lm16.uo.service.impl;

import com.lm16.uo.bean.Attachment;
import com.lm16.uo.dao.AttachmentDao;
import com.lm16.uo.service.AttachmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Resource
    private AttachmentDao attachmentDao;

    @Override
    public Attachment save(Attachment attachment) {
        return attachmentDao.save(attachment);
    }
}
