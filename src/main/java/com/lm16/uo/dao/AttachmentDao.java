package com.lm16.uo.dao;

import com.lm16.uo.bean.Attachment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttachmentDao extends MongoRepository<Attachment, String> {



}
