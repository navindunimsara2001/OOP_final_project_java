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
                            <input type="text" name="district" id="district"
                                   value="<%=request.getAttribute("district")%>"
                                <%=Objects.equals(request.getAttribute("edit"), true) ? "":"disabled"%>>
                        </td>
                    </tr>
                    <%}%>


                    <% if (Objects.equals(request.getAttribute("edit"), true)) {%>
                    <tr class="field">
                        <td>
                            <label class="label" for="password">Password : </label>
                        </td>
                        <td>
                            <input type="password" name="password" id="password"
                                   value="<%=request.getAttribute("password")%>">
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
                <div class="btn-group" role="group">
                    <a class="btn btn-primary" href="${requestScope.get("url")}?edit=true">Edit</a>
                </div>
                <%}%>

            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>