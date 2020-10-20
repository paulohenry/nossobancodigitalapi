package com.paulohenry.zup.nbdigital.utils;

import java.io.IOException;
import java.util.stream.Stream;

import com.paulohenry.zup.nbdigital.localstorage.LocalRegisterRepository3;
import com.paulohenry.zup.nbdigital.entities.local.LocalRegisterEntity3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class UpDataService {

  @Autowired
  private LocalRegisterRepository3 storage3;

  public LocalRegisterEntity3 store(MultipartFile file, LocalRegisterRepository3 storage3) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    this.storage3 = storage3;
    LocalRegisterEntity3 FileDB = new LocalRegisterEntity3(fileName, file.getContentType(), file.getBytes());
    return storage3.save(FileDB);
  }

  public LocalRegisterEntity3 getFile(String id) {
    return storage3.findById(id).get();
  }
  
  public Stream<LocalRegisterEntity3> getAllFiles() {
    return storage3.findAll().stream();
  }
}