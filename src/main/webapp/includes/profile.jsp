<%@ page import="java.util.Objects" %>
<div class="container">
    <h2>User Profile</h2>
    <div class="propic">
        <ion-icon name="person-circle-outline" style="font-size: 128px"></ion-icon>
    </div>

    <div class="row">
        <div class="col-3"></div>
        <div class="col d-flex justify-content-center" id="col">
            <form action="" method="post">
                <table>
                    <tr>
                        <th>
                            <div class="field">
                                <label class="label" for="Name">Name : </label>
                            </div>
                        </th>
                        <th>
                            <div class="field">
                                <input type="text" name="name" id="Name"
                                       value="<%=request.getAttribute("name")%>"
                                    <%=Objects.equals(request.getAttribute("edit"), true) ? "":"disabled"%>>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <div class="field">
                                <label class="label" for="PhoneNumber">Phone : </label>
                            </div>
                        </th>
                        <th>
                            <div class="field">
                                <input type="text" name="phone" id="PhoneNumber"
                                       value="<%=request.getAttribute("phone")%>"
                                    <%=Objects.equals(request.getAttribute("edit"), true) ? "":"disabled"%>>
                            </div>
                        </th>
                    </tr>
                    <tr>

                        <th>
                            <div class="field">
                                <label class="label" for="DOB">DOB : </label>
                            </div>
                        </th>


                        <th>
                            <div class="field">
                                <input type="date" name="DOB" id="DOB"
                                       value="<%=request.getAttribute("DOB")%>"
                                    <%=Objects.equals(request.getAttribute("edit"), true) ? "":"disabled"%>>
                            </div>
                        </th>

                    </tr>
                    <% if (!Objects.isNull(request.getAttribute("district"))) {%>
                    <tr>
                        <th>
                            <div class="field">
                                <label class="label" for="district"> District : </label>
                            </div>
                        </th>
                        <th>
                            <div class="field">
                                <input type="text" name="district" id="district"
                                       value="<%=request.getAttribute("district")%>"
                                    <%=Objects.equals(request.getAttribute("edit"), true) ? "":"disabled"%>>
                            </div>
                        </th>
                    </tr>
                    <%}%>


                    <% if (Objects.equals(request.getAttribute("edit"), true)) {%>
                    <tr>
                        <th>
                            <div class="field">
                                <label class="label" for="password">Password : </label>
                            </div>
                        </th>
                        <th>
                            <div class="field">
                                <input type="password" name="password" id="password"
                                       value="<%=request.getAttribute("password")%>">
                            </div>
                        </th>
                    </tr>
                    <%}%>
                </table>
                <input type="hidden" name="ID" value="<%=request.getAttribute("ID")%>">
                <% if (Objects.equals(request.getAttribute("edit"), true)) {%>
                <input class="btn btn-primary" type="submit" value="Update">
                <a class="btn btn-danger"
                   href="?ID=<%=request.getAttribute("ID")%>&action=delete">Delete</a>
                <%} else {%>
                <div class="btn-group" role="group">
                    <a class="btn btn-primary" href="?edit=true">Edit</a>
                </div>
                <%}%>

            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>