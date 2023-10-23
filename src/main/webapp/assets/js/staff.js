$("#addStaff").on("click", _ => {
    let model = $('#addStaffModal');
    model.find('form')[0].reset();
    model.find("#modalTitle").text("Add Staff Member");
    model.find("#modalAction").text("Add Staff");
    model.modal('show');
})


$(".staff-edit-btn").each((_, e) => {
    e.addEventListener("click", () => {
        let model = $('#addStaffModal');
        model.find('form')[0].reset();
        model.find("#modalTitle").text("Edit Staff Member");
        model.find("#modalAction").text("Save Changes");
        model.find("#ID").val(e.dataset["id"]);
        model.find('#name').val(e.dataset['name']);
        model.find('#email').val(e.dataset['email']);
        model.find('#phone').val(e.dataset['phone']);
        model.find('#DOB')[0].valueAsNumber = Date.parse(e.dataset['dob']);
        model.find('#role').val(e.dataset['role']);
        model.modal('show');
    });
})