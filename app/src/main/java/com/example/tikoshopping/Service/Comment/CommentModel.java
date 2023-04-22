package com.example.tikoshopping.Service.Comment;

import java.sql.Date;

public class CommentModel {
    public int IDComment ;
    public int IDUser ;
    public String UserName ;
    public String Content ;
    public Date CreateAt ;
    public Date UpdateAt ;

    public CommentModel(int IDComment, int IDUser, String userName, String content, Date createAt, Date updateAt) {
        this.IDComment = IDComment;
        this.IDUser = IDUser;
        UserName = userName;
        Content = content;
        CreateAt = createAt;
        UpdateAt = updateAt;
    }
}
