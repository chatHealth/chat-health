<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: wonu--%>
<%--  Date: 10/20/23--%>
<%--  Time: 15:28--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../include/member-side.jsp" %>

<!-- Content -->
    <!-- Profile Picture and Table on the Same Row -->
    <div class="row" style="padding-top: 10%;">
        <div class="col-4">
            <!-- Profile Picture -->
            <div class="profile-picture">
                <c:choose>
                <c:when test="${loggedMember.profile eq 'null'}">
                    <img src="../img/basic_profile.svg" alt="없음">
                </c:when>
                <c:otherwise>
                    <img src="/upload/${loggedMember.profile }" alt="멤버프로필">
                </c:otherwise>
                </c:choose>
                <div class="edit-button">
                    <button id="editBtn" class="btn" style="background: gray; border: none;">Edit</button>
                    <!-- 프로필 사진 업로드 Modal-->
                    <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="profileModalLabel">프로필 사진 변경</h5>
                                </div>
                                <form action="../personal/member-profile-image" enctype="multipart/form-data"
                                      method="post">
                                    <div class="modal-body">
                                        <!-- 프로필 사진 업로드 양식 -->
                                        <div class="form-group">
                                                <c:choose>
                                                    <c:when test="${loggedMember.profile eq 'null'}">
                                                        <img src="../img/basic_profile.svg" alt="없음" id="preview" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img src="/upload/${loggedMember.profile }" alt="멤버프로필" id="preview" />
                                                    </c:otherwise>
                                                </c:choose>
                                            <input type="file" class="form-control-file" id="profileImage"
                                                   name="profileImage" accept="image/*"  />
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="close">
                                            닫기
                                        </button>
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
                        <td class="w-75">${loggedMember.name }</td>
                    </tr>
                    <tr>
                        <th scope="row" class="w-25">NickName</th>
                        <td class="w-75">${loggedMember.nickName }</td>
                    </tr>
                    <tr>
                        <th scope="row" class="w-25">Address</th>
                        <td class="w-75">${loggedMember.address }</td>
                    </tr>
                    <tr>
                        <th scope="row" class="w-25">Address Detail</th>
                        <td class="w-75">${loggedMember.addressDetail }</td>
                    </tr>
                    <tr>
                        <th scope="row" class="w-25">E-Mail</th>
                        <td class="w-75">${loggedMember.email }</td>
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
    $('#editBtn').click(function (e) {
        e.preventDefault();
        $('#editModal').modal("show");
    });
    $('#close').click(function (e) {
        e.preventDefault();
        $('#editModal').modal("hide");
    });

    $('#profileImage').change(function(){
        setImageFromFile(this, '#preview');
    });

    function setImageFromFile(input, expression) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $(expression).attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
<%@ include file="../include/footer.jsp" %>