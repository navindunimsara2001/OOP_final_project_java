<%@ page import="java.util.Objects" %>
<div class="profile-container">
    <h2 class="profile-header">User Profile</h2>
    <div class="profile-pic">
        <ion-icon name="person-circle-outline" style="font-size: 128px"></ion-icon>
    </div>

    <div class="row">
        <div class="col d-flex justify-content-center" id="col">
            <form action="${requestScope.get("url")}" method="post">
                <table>
                    <tr class="field">
                        <td>
                            <label class="label" for="Name">Name : </label>
                        </td>
                        <td>
                            <input type="text" name="name" id="Name"
                                   value="<%=request.getAttribute("name")%>"
                                <%=Objects.equals(request.getAttribute("edit"), true) ? "":"disabled"%>>
                        </td>
                    </tr>
                    <tr class="field">
                        <td>
                            <label class="label" for="PhoneNumber">Phone : </label>
                        </td>
                        <td>
                            <input type="text" name="phone" id="PhoneNumber"
                                   value="<%=request.getAttribute("phone")%>"
                                <%=Objects.equals(request.getAttribute("edit"), true) ? "":"disabled"%>>
                        </td>
                    </tr>
                    <tr class="field">

                        <td>
                            <label class="label" for="DOB">DOB : </label>
                        </td>
                        <td>
                            <input type="date" name="DOB" id="DOB"
                                   value="<%=request.getAttribute("DOB")%>"
                                <%=Objects.equals(request.getAttribute("edit"), true) ? "":"disabled"%>>
                        </td>

                    </tr>
                    <% if (!Objects.isNull(request.getAttribute("district"))) {%>
                    <tr class="field">
                        <td>
                            <label class="label" for="district"> District : </label>
                        </td>
                        <td>
                            <select name="district" class="select-box" id="district" required
                                    data-selected="<%=request.getAttribute("district")%>" <%=Objects.equals(request.getAttribute("edit"), true) ? "" : "disabled"%>>
                                <option value="Colombo">Colombo</option>
                                <option value="Gampaha">Gampaha</option>
                                <option value="Kalutara">Kalutara</option>
                                <option value="Kandy">Kandy</option>
                                <option value="Matale">Matale</option>
                                <option value="Nuwara Eliya">Nuwara Eliya</option>
                                <option value="Galle">Galle</option>
                                <option value="Matara">Matara</option>
                                <option value="Hambantota">Hambantota</option>
                                <option value="Jaffna">Jaffna</option>
                                <option value="Kilinochchi">Kilinochchi</option>
                                <option value="Mannar">Mannar</option>
                                <option value="Vavuniya">Vavuniya</option>
                                <option value="Mullaitivu">Mullaitivu</option>
                                <option value="Batticaloa">Batticaloa</option>
                                <option value="Ampara">Ampara</option>
                                <option value="Trincomalee">Trincomalee</option>
                                <option value="Kurunegala">Kurunegala</option>
                                <option value="Puttalam">Puttalam</option>
                                <option value="Anuradhapura">Anuradhapura</option>
                                <option value="Polonnaruwa">Polonnaruwa</option>
                                <option value="Badulla">Badulla</option>
                                <option value="Moneragala">Moneragala</option>
                                <option value="Ratnapura">Ratnapura</option>
                                <option value="Kegalle">Kegalle</option>
                            </select>
                        </td>
                    </tr>
                    <%}%>


                </table>
                <input type="hidden" name="ID" value="<%=request.getAttribute("ID")%>">
                <% if (Objects.equals(request.getAttribute("edit"), true)) {%>
                <input class="btn btn-primary" type="submit" value="Update">
                <a class="btn btn-danger"
                   href="${requestScope.get("url")}?ID=<%=request.getAttribute("ID")%>&action=delete">Delete</a>
                <%} else {%>

                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editPassword" type="button">
                    Change Password
                </button>

                <div class="btn-group" role="group">
                    <a class="btn btn-primary" href="${requestScope.get("url")}?edit=true">Edit</a>
                </div>
                <%}%>

            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>

<div class="modal" tabindex="-1" role="dialog" id="editPassword">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalTitle">Change Password</h5>
                <button type="button" class="close btn btn-outline-secondary" data-bs-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="${requestScope.get("url")}?action=password" method="post" class="form" id="pswForm">
                <div class="modal-body">
                    <div class="input-box">
                        <label>Password :
                            <input type="password" placeholder="Enter password" name="password" id="password" required>
                        </label>
                    </div>
                    <div class="input-box">
                        <label>Confirm Password :
                            <input type="password" placeholder="Renter password" name="password-conf" id="password-conf"
                                   required>
                        </label>
                    </div>
                    <input type="hidden" name="ID" id="${sessionScope.get("id")}">
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" id="modalAction" disabled>Update password</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>

    $("#pswForm").on("input", () => {
        let psw1 = $("#pswForm #password").val();
        let psw2 = $("#pswForm #password-conf").val();
        $("#pswForm #modalAction")[0].disabled = psw1 !== psw2 || psw1.length < 8;
    })

</script>
