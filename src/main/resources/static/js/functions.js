function checkjQuery() {
    if (typeof jQuery !== undefined) {
        console.log("jQuery er loaded");
    } else {
        console.log("jQuery er ikke loaded");
    }
}

function preventAddForm(addform) {
    addform.submit(function (event) {
        event.preventDefault();
        addStudent($("#name").val(), $("#eMail").val(), $("#supervisor").val())
    });
}

function addStudent(name, eMail, supervisor) {
    var addObject = {};
    addObject["name"] = name;
    addObject["eMail"] = eMail;
    addObject["supervisor"] = supervisor;

    $.ajax({
        url: "/api/addStudent",
        type: "POST",
        contentType: "application/JSON",
        data: JSON.stringify(addObject),
        success: function (data) {
            console.log("success, svar fra server");
            //     console.log(addObject.eMail);
            //      $("#status").html(JSON.stringify(addObject));
            updateTable();

        },
        error: function (data) {
            // $("#status").html("Error, ingen svar fra server")
            console.log("ingen success")
        }
    })
}







