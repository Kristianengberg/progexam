function get() {
/*
    // GET REQUEST
    $("#getAllStudents").click(function (event) {
        event.preventDefault();
        ajaxGet();
    });

 */
    ajaxGet();

    // DO GET
    function ajaxGet() {
        $.ajax({
            type: "GET",
            url: "/api/showStudents",
            success: function (result) {
                $('#getResultDiv ul').empty();

                $.each(result, function (i, student) {
                        console.log("IN SUCCESS");
                        let user =
                            "Name  "
                            + "<input type='text' value='" + student.name + "'>"
                            + " E-mail   " + "<input type='text' value='" + student.eMail + "'>"
                            + " Supervisor "+ "<input type='text' value='" + student.supervisor.id + "'>"
                            + "<input type='hidden' id='"+ student.id +"' name='" + student.id + "' value='"+ student.id + "'>"
                            + "<button onclick='deleteStudent("+student.id+")' id='' type='button' >Delete</button>"
                            + "<button onclick='updateStudent("+student+")' id='' type='button' >Update</button>"
                            +"<br>";
                        $('#getResultDiv .list-group').append(
                            user)
                    });

                console.log("Success: ", result);

            },
            error: function (e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
}

function deleteStudent(id){
    console.log("clicked delete on " + student.id);
    ajaxDelete(id);

}

function ajaxDelete(id) {

    // PREPARE FORM DATA
    let formData = {
    id: id
    }

    // DO POST
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/deleteStudent",
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

function updateStudent(name, email, email, supervisor){
    console.log("clicked update student with id ", id);
    //ajaxUpdate(student);
}

function ajaxUpdate(student){
    // PREPARE FORM DATA
    let formData = {
        id: student.id,
        name: student.name,
        eMail: student.eMail,
        supervisor: student.supervisor.id
    }

    console.log(formData);

    // DO POST
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/updateStudent",
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




