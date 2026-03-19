package com.ibby.lab.minesweeper.app.box.xml;


import com.ibby.lab.minesweeper.app.box.xml.structure.Application;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.net.URL;

public class XmlReader {
  public Application unmarshal(String fileName) {
    if (!fileName.contains(".xml")) {
      fileName = fileName + ".xml";
    }
    URL resource = this.getClass().getClassLoader().getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("File not found! " + fileName);
    }
    File file = new File(resource.getFile());

    try {
      JAXBContext context = JAXBContext.newInstance(Application.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      return (Application) unmarshaller.unmarshal(file);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }
}
