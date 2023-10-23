$(".edit-btn").each((_, e) => {
    console.log("v", e);
    e.addEventListener("click", () => {
        let model = $('#appointmentEdit');
        model.find('form')[0].reset();
        model.find("#apt-id").val(e.dataset["aptId"]);
        model.find('#assigned').val(e.dataset['aptStaff']);
        model.find("#approved").prop({"checked": e.dataset['aptApproved'] === 'true'});

        model.modal('show');
    });
})