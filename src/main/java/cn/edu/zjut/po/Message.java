package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("message")
public class Message {
    private Integer no;
    private String title;
    private String content;
    private Date sendTime;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
