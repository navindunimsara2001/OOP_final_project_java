$(".edit-user-btn").each((_, e) => {
    e.addEventListener("click", () => {
        let model = $('#userEditModal');
        model.find('form')[0].reset();
        model.find('form')[0].action = "staff/editUser?ID=" + e.dataset["id"];
        model.find("#ID").val(e.dataset["id"]);
        model.find('#name').val(e.dataset['name']);
        model.find('#phone').val(e.dataset['phone']);
        model.find('#DOB')[0].valueAsNumber = Date.parse(e.dataset['dob']);
        model.find('#district').val(e.dataset['district']);
        model.modal('show');
    });
})