package bo;

import java.util.Date;

/**
 * 动漫Bean
 */
public class Anime {
    private Integer id;
    private String name;
    private String note;
    private String pic;
    private String file;
    private Integer type;
    private Date createTime;
    private String inputer;
    private String animeClassName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInputer() {
        return inputer;
    }

    public void setInputer(String inputer) {
        this.inputer = inputer;
    }

    public void setAnimeClassName(String animeClassName) {
        this.animeClassName = animeClassName;
    }

    public String getAnimeClassName() {
        return animeClassName;
    }
}
