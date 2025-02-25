package edu.cnm.deepdive.nasaapod.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.net.URL;
import java.time.LocalDate;

@Entity(
    tableName = "apod",
    indices = {
        @Index(value = {"date"}, unique = true)
    }
)

public class Apod {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "apod_id")
  private long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @ColumnInfo(index = true, collate = ColumnInfo.NOCASE)
  @NonNull
  @Expose
  private String title;

  @ColumnInfo(collate = ColumnInfo.NOCASE)
  @Expose
  @SerializedName("explanation")
  private String description;

  @NonNull
  @Expose
  private LocalDate date;

  @Expose

  private String copyright;

  @ColumnInfo(name = "media_type", index = true)
  @NonNull
  @SerializedName("media_type")
  @Expose
  private MediaType mediaType;

  @ColumnInfo(name = "low_def_url")
  @NonNull
  @SerializedName("url")
  @Expose
  private URL lowDefUrl;

  @ColumnInfo(name = "high_def_url")
  @Expose
  @SerializedName("hdurl")
  private URL highDefUrl;


  @NonNull
  public String getTitle() {
    return title;
  }

  public void setTitle(@NonNull String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @NonNull
  public LocalDate getDate() {
    return date;
  }

  public void setDate(@NonNull LocalDate date) {
    this.date = date;
  }

  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  @NonNull
  public MediaType getMediaType() {
    return mediaType;
  }

  public void setMediaType(@NonNull MediaType mediaType) {
    this.mediaType = mediaType;
  }

  @NonNull
  public URL getLowDefUrl() {
    return lowDefUrl;
  }

  public void setLowDefUrl(@NonNull URL lowDefUrl) {
    this.lowDefUrl = lowDefUrl;
  }

  public URL getHighDefUrl() {
    return highDefUrl;
  }

  public void setHighDefUrl(URL highDefUrl) {
    this.highDefUrl = highDefUrl;
  }

  public enum MediaType {
    @SerializedName("image")
    IMAGE(true),
    @SerializedName("video")
    VIDEO(false);

    private final boolean downloadable;

    MediaType(boolean downloadable) {
      this.downloadable = downloadable;
    }

    public boolean isDownloadable() {
      return downloadable;
    }

  }

}
