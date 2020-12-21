function post() {


    // SUBMIT FORM
    $("#studentForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();

    });

    function ajaxPost() {

        // PREPARE FORM DATA
        var formData = {
            name: $("#name").val(),
            eMail: $("#eMail").val(),
            supervisor: $("#supervisor").val()
        }

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/JSON",
            url: "/api/addStudent",
            data: JSON.stringify(formData),
            success: function (result) {
                get();

                console.log(result);
            },
            error: function (e) {

                console.log("ERROR: ", e);
            }
        });

    }

}