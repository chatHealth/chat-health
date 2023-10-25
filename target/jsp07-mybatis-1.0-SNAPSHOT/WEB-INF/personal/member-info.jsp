<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: wonu--%>
<%--  Date: 10/20/23--%>
<%--  Time: 15:28--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

    <style>
        .sidebar {
            background-color: #f8f9fa; /* Lighter color */
            width: 240px; /* Fixed width */
            height: 100%; /* 100% height */
            overflow-y: auto;
            position: fixed;
            left: 0;
        }

        .sidebar h1 {
            color: #000000;
            font-size: 1.5rem;
            margin: 20px;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
        }

        .sidebar ul li {
            margin-bottom: 10px;
        }

        .sidebar a {
            text-decoration: none;
            color: #000000;
            transition: color 0.3s, background-color 0.3s; /* Transition properties */
            padding: 10px; /* Add padding to create background space */
        }

        .sidebar a:hover {
            color: #6c757d; /* Text color on hover */
            background-color: #f8f9fa; /* Background color on hover */
        }

        .content {
            background-color: #ffffff;
            padding: 20px;
            margin-left: 240px; /* Adjust this margin for the initial sidebar width */
        }

        .profile-picture {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            overflow: hidden;
            position: relative;
            margin: 0 auto;
        }

        .profile-picture img {
            width: 100%;
            height: 100%;
        }

        .edit-button {
            position: absolute;
            bottom: 10px;
            right: 10px;
        }

        .table-container {
            position: relative;
        }

        .info-text {
            position: absolute;
            top: 0;
            right: 0;
            font-size: 0.8rem;
            color: #6c757d;
        }

        @media (max-width: 768px) {
            .sidebar {
                width: 0;
            }
            .content {
                margin-left: 0;
            }
        }
    </style>
<div class="container-fluid">
    <div class="row">
<%--        <button class="btn btn-primary mt-2 ml-2" id="sidebar-toggle">Toggle Sidebar</button>--%>

        <!-- Sidebar -->
        <div class="col sidebar">
            <h1>Sidebar</h1>
            <ul>
                <li><a href="../personal/member-info">내 정보</a></li>
                <li><a href="../personal/member-password">비밀번호 변경</a></li>
                <li><a href="../personal/member-wish">관심 제품</a></li>
                <li><a href="../personal/member-review">내 리뷰</a></li>
                <li><a href="../personal/member-comments">내 댓글</a></li>
                <li><a href="../personal/member-withdraw">회원 탈퇴</a></li>
            </ul>
        </div>

        <!-- Content -->
        <div class="col-9 content">
            <!-- Profile Picture and Table on the Same Row -->
            <div class="row" style="padding-top: 10%;">
                <div class="col-4">
                    <!-- Profile Picture -->
                    <div class="profile-picture">
<%--                        <img src="https://via.placeholder.com/150" alt="Profile Picture">--%>
                        <img src="/uploadProfile/${loginSession.profile }" alt="Profile Picture">
                        <div class="edit-button">
<%--                            <button class="btn btn-primary" style="background: none; border: none; color: white;">Edit</button>--%>
<%--                        </div>--%>
                        <button id="editBtn" class="btn" style="background: none; border: none;">Edit</button>
                        <!-- 회원가입 확인 Modal-->
                        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                    <h5 class="modal-title" id="profileModalLabel">프로필 사진 변경</h5>
                                    </div>
                                    <form action="../personal/member-profile-image" enctype="multipart/form-data" method="post">
                                    <div class="modal-body">
                                    <!-- 프로필 사진 업로드 양식 -->
                                    <div class="form-group">
<%--                                    <label for="profileImage">프로필 사진 업로드</label>--%>
                                    <input type="file" class="form-control-file" id="profileImage" name="profileImage">
                                    </div>
                                    </div>
                                    <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal" id="close">닫기</button>
                                    <button type="submit" class="btn btn-primary">저장</button>
                                    </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="col-8">
                    <!-- Profile Info Table and '정보 수정' text -->
                    <div class="table-container">
                        <h2 class="text-2xl font-weight-bold">Profile Info</h2>
                        <table class="table table-striped">
                            <tbody>
                            <tr>
                                <th scope="row" class="w-25">Name</th>
                                <td class="w-75">${loginSession.name }</td>
                            </tr>
                            <tr>
                                <th scope="row" class="w-25">NickName</th>
                                <td class="w-75">${loginSession.nickname }</td>
                            </tr>
                            <tr>
                                <th scope="row" class="w-25">Address</th>
                                <td class="w-75">${loginSession.address }</td>
                            </tr>
                            <tr>
                                <th scope="row" class="w-25">Address Detail</th>
                                <td class="w-75">${loginSession.addressDetail }</td>
                            </tr>
                            <tr>
                                <th scope="row" class="w-25">E-Mail</th>
                                <td class="w-75">${loginSession.email }</td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="info-text"><a href="../personal/member-modify" style="color:inherit">정보 수정</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $('#editBtn').click(function(e){
        e.preventDefault();
        $('#editModal').modal("show");
    });
    $('#close').click(function(e){
        e.preventDefault();
        $('#editModal').modal("hide");
    });
</script>
<%@ include file="../include/footer.jsp" %>