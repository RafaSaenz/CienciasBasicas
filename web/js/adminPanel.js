/* 
 * AJAX functions for AdminPanel JSP and DataServlet
 */
/*
 **** ------ TOPICS ------ ****
 */
//Boostrap topics table filtering
$(document).on("keyup", '#myTopic', function (event) {
    var value = $(this).val().toLowerCase();
    $("#myTopicTbl tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});
//Show topics table
function showTopics(area) {
    $.get("/CienciasBasicas/Topics",
            {
                action: "show",
                area: area
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on area to show topics table
$(document).on("click", '.area-link', function (event) {
    event.preventDefault();
    showTopics(event.target.getAttribute('id'));
});
// Show input for new topic
$(document).on("click", '#add-topic', function (event) {
    $("#topic-input").show();
    $("#topic-edit").hide();
});
// Save new topic
$(document).on("click", '#save-topic', function (event) {
    event.preventDefault();
    if ($("#topic").val() !== "") {
        $.get("/CienciasBasicas/Topics",
                {
                    area: $("#add-topic").attr('name'),
                    action: "add",
                    id: $("#topic").val()
                },
                function (data, status) {
                    $("#topic").val("");
                    showTopics($("#add-topic").attr('name'));
                    $("#topic-input").show();
                    $("#topic-edit").hide();
                });
    } else {
        alert("Debe escribir el nombre del tema");
    }
});
//Enable/Disable a Topic
$(document).on("click", '.enable-btn', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Topics",
            {
                area: $("#add-topic").attr('name'),
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showTopics($("#add-topic").attr('name'));
            });
});
// Show input for editing a topic
$(document).on("click", '.edit-btn', function (event) {
    $("#topic-edit").show();
    $("#topic-input").hide();
    var tmp = $(event.target).parent().parent().siblings(":first").text();
    var tmp2 = $(event.target).parent().parent().siblings(":nth-child(2)").text();
    $("#edit-topic").val(tmp);
    $("#update-topic").data("id", tmp2);
});
// Update the topic
$(document).on("click", '#update-topic', function (event) {
    event.preventDefault();
    if ($("#edit-topic").val() !== "") {
        $.get("/CienciasBasicas/Topics",
                {
                    area: $("#add-topic").attr('name'),
                    action: "update",
                    id: $("#update-topic").data('id'),
                    name: $("#edit-topic").val()
                },
                function (data, status) {
                    showTopics($("#add-topic").attr('name'));
                });
    } else {
        alert("Empty");
    }
});
/*
 **** ------ END OF TOPICS ------ ****
 */

/*
 **** ------ SUBTOPICS ------ ****
 */
//Boostrap subtopics table filtering
$(document).on("keyup", '#mySubtopic', function (event) {
    var value = $(this).val().toLowerCase();
    $("#mySubtopicTbl tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});
// Function to get subtopics table
function showSubtopics(topic) {
    $('.modal-body').load("/CienciasBasicas/Subtopics",
            {
                action: "show",
                topic: topic
            },
            function () {
                $('#myModal').modal({show: true});
            });
}
// Show subtopics table on modal
$(document).on("click", '.modalBtn', function (event) {
    event.preventDefault();
    var tmp = $(event.target).closest('tr').attr('id');
    showSubtopics(tmp);
});
// Show input for new subtopic
$(document).on("click", '#add-subtopic', function (event) {
    $("#subtopic-input").show();
    $("#subtopic-edit").hide();
});
// Save new subtopic
$(document).on("click", '#save-subtopic', function (event) {
    event.preventDefault();
    if ($("#subtopic").val() !== "") {
        $.get("/CienciasBasicas/Subtopics",
                {
                    topic: $("#add-subtopic").attr('name'),
                    action: "add",
                    id: $("#subtopic").val()
                },
                function (data, status) {
                    $("#subtopic").val("");
                    showSubtopics($("#add-subtopic").attr('name'));
                    $("#subtopic-input").show();
                    $("#subtopic-edit").hide();
                });
    } else {
        alert("Debe escribir el nombre del subtema");
    }
});
//Enable/Disable a Subtopic
$(document).on("click", '.enable-btn2', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Subtopics",
            {
                topic: $("#add-subtopic").attr('name'),
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showSubtopics($("#add-subtopic").attr('name'));
            });
});
// Show input for editing a subtopic
$(document).on("click", '.edit-btn2', function (event) {
    $("#subtopic-edit").show();
    $("#subtopic-input").hide();
    var tmp = $(event.target).parent().parent().siblings(":first").text();
    var tmp2 = $(event.target).parent().parent().siblings(":nth-child(2)").text();
    $("#edit-subtopic").val(tmp);
    $("#update-subtopic").data("id", tmp2);
});
// Update the subtopic
$(document).on("click", '#update-subtopic', function (event) {
    event.preventDefault();
    if ($("#edit-subtopic").val() !== "") {
        $.get("/CienciasBasicas/Subtopics",
                {
                    topic: $("#add-subtopic").attr('name'),
                    action: "update",
                    id: $("#update-subtopic").data('id'),
                    name: $("#edit-subtopic").val()
                },
                function (data, status) {
                    showSubtopics($("#add-subtopic").attr('name'));
                });
    } else {
        alert("Empty");
    }
});
/*
 **** ------ END OF SUBTOPICS ------ ****
 */

/*
 **** ------ RESOURCES ------ ****
 */
//Show resources table
function showResources() {
    $.get("/CienciasBasicas/Resources",
            {
                action: "view",
                mode: "table",
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on resources to show reources table
$(document).on("click", '#man-res', function (event) {
    event.preventDefault();
    showResources();
});
//Enable/Disable a Resource
$(document).on("click", '.enable-btn3', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/DataServlet",
            {
                items: "resources",
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showResources();
            });
});
/*
 **** ------ END OF RESOURCES ------ ****
 */


/*
 **** ------ INSTRUCTORS ------ ****
 */
//Show instructors table
function showInstructors() {
    $.get("/CienciasBasicas/Instructors",
            {
                action: "view",
                mode: "table",
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on instructors to show instructors table
$(document).on("click", '#man-ins', function (event) {
    event.preventDefault();
    showInstructors();
});
//Enable/Disable an Instructor
$(document).on("click", '.enable-btn4', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Instructors",
            {
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showInstructors();
            });
});
//Modify an Instructor
/*
$(document).on("click", '#edit-btn4', function (event) {
    event.preventDefault();
        $.get("/CienciasBasicas/Instructors",
                {
                    action: "add",
                    id: $("#edit-btn4").data('id'),
                    //name: $("#edit-subtopic").val()
                },
                function (data, status) {
                    showInstructors();
                });

});*/

/*
 **** ------ END OF INSTRUCTORS ------ ****
 */


