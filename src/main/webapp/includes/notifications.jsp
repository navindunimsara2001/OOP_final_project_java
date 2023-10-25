<%@ page import="com.util.Notify" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.ArrayList" %>
<script>
    <% ArrayList<Notify.Message> messages= Notify.fetch(request);%>
    var notify = [
        <% if (!Objects.isNull(messages)){ %>
        <% for (Notify.Message msg: messages){%>
        {
            'type': '<%=msg.getType().toString()%>',
            'msg': '<%=msg.getMsg()%>',
        },
        <%}%>
        <%}%>
    ]
</script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="assets/js/notify.js"></script>

<style>

    .swal2-icon-success {
        background-color: #a5dc86 !important;
    }

    .swal2-icon-error {
        background-color: #f27474 !important;
    }

    .swal2-icon-warning {
        background-color: #f8bb86 !important;
    }

    .swal2-icon-info {
        background-color: #3fc3ee !important;
    }
</style>