package com.ibby.lab.minesweeper.app.box.xml.structure;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "application")
@XmlAccessorType(XmlAccessType.FIELD)
public class Application {
  @XmlAttribute(name = "title")
  private String title;

  @XmlElement(name = "text")
  private List<Text> textList;

  @XmlElement(name = "endText")
  private String endText;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Text> getTextList() {
    return textList;
  }

  public void setTextList(List<Text> textList) {
    this.textList = textList;
  }

  public String getEndText() {
    return endText;
  }

  public void setEndText(String endText) {
    this.endText = endText;
  }
}
