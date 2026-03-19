package com.ibby.lab.minesweeper.app.box.xml.structure;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Text {
  @XmlAttribute(name = "id")
  private int id;

  @XmlElement(name = "content")
  private String content;

  public int getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

}
