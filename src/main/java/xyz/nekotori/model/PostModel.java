package xyz.nekotori.model;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Author: Dengjay
 * Date: 2020/10/20
 * Time: 10:38
 */

@Data
public class PostModel {
    @SerializedName("file_url")
    private String fileUrl;

    @SerializedName("frames_pending")
    private String framesPending;

    @SerializedName("frames_pending_string")
    private String framesPendingString;

    @SerializedName("jpeg_file_size")
    private Long jpegFileSize;

    @SerializedName("jpeg_width")
    private int jpegWidth;

    @SerializedName("preview_width")
    private int previewWidth;

    @SerializedName("rating")
    private String rating;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("jpeg_height")
    private int jpegHeight;

    @SerializedName("source")
    private String source;

    @SerializedName("score")
    private int score;

    @SerializedName("sample_height")
    private int sampleHeight;

    @SerializedName("sample_url")
    private String sampleUrl;

    @SerializedName("actual_preview_height")
    private int actualPreviewHeight;

    @SerializedName("id")
    private Long id;

    @SerializedName("height")
    private int height;

    @SerializedName("frames_string")
    private String framesString;

    @SerializedName("frames")
    private String frames;

    @SerializedName("has_children")
    private boolean hasChildren;

    @SerializedName("author")
    private String author;

    @SerializedName("change")
    private Long change;

    @SerializedName("sample_width")
    private int sampleWidth;

    @SerializedName("preview_height")
    private int previewHeight;

    @SerializedName("sample_file_size")
    private Long sampleFileSize;

    @SerializedName("file_size")
    private Long fileSize;

    @SerializedName("tags")
    private String tags;

    @SerializedName("jpeg_url")
    private String jpegUrl;

    @SerializedName("preview_url")
    private String previewUrl;

    @SerializedName("creator_id")
    private Long creatorId;

    @SerializedName("width")
    private int Width;

    @SerializedName("actual_preview_width")
    private int actualPreviewWidth;

    @SerializedName("is_held")
    private boolean isHeld;

    @SerializedName("is_show_index")
    private boolean isShowInIndex;

    @SerializedName("md5")
    private String md5;

    @SerializedName("satus")
    private String status;
}
