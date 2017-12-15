// Table filtering (non-modal)
$(document).on("keyup", '#myTopic', function (event) {
    var value = $(this).val().toLowerCase();
    $("#myTopicTbl tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});
// Table filtering (modal)
$(document).on("keyup", '#mySubtopic', function (event) {
    var value = $(this).val().toLowerCase();
    $("#mySubtopicTbl tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});
/*
 **** ------ EDIT RESOURCE MODAL ------ ****
 */
$(document).on("change", "#area-slct", function (event) {
    $("#topic-slct").empty();
    $("#subtopic-slct").empty();
    $.get("/CienciasBasicas/Topics",
            {
                action: "select",
                area: $("#area-slct").val()
            },
            function (data, status) {
                $("#topic-slct").html(data);
            }
    );
});
$(document).on("change", "#topic-slct", function (event) {
    $("#subtopic-slct").empty();
    $.get("/CienciasBasicas/Subtopics",
            {
                action: "select",
                topic: $("#topic-slct").val()
            },
            function (data, status) {
                $("#subtopic-slct").html(data);
            }
    );
});
/*
 **** ------ END OF EDIT RESOURCE MODAL ------ ****
 */
/*
 **** ------ MANAGE RESOURCES ------ ****
 */
// Function to show resources table
function showResources() {
    $.get("/CienciasBasicas/Resources",
            {
                action: "view",
                mode: "table"
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on "Recursos"
$(document).on("click", '#man-res', function (event) {
    event.preventDefault();
    showResources();
});
//Enable/Disable a Resource
$(document).on("click", '.enable-r', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Resources",
            {
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showResources();
            });
});
// Update a resource
$(document).on("click", '.edit-r', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Resources",
            {
                action: "edit-form",
                r_id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                $('.modal-body').html(data);
                $('.modal-title').html('Editar recurso:');
                $('.btn-default').html('<i class="fa fa-floppy-o"></i> Guardar Cambios');
                $('#adminModal').modal({show: true});
            });
});
// Updating files from a resource
$(document).on("click", '.edit-f', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Resources",
            {
                action: "edit-form2",
                r_id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                $('.modal-body').html(data);
                $('.modal-title').html('Manejo de materiales:');
                $('.btn-default').html('<i class="fa fa-floppy-o"></i> Guardar Cambios');
                $('.input-row').hide();
                $('#adminModal').modal({show: true});
            });
});
/*
 **** ------ END OF RESOURCES ------ ****
 */
/*
 **** ------ MANAGE TYPES ------ ****
 */
// Function to show ResourceTypes table
function showTypes() {
    $.get("/CienciasBasicas/ResTypes",
            {
                action: "show"
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on area to show topics table
$(document).on("click", '#man-types', function (event) {
    event.preventDefault();
    showTypes();
});
// Click on '+' to show input for new resource type
$(document).on("click", '#add-type', function (event) {
    $("#type-input").show();
    $("#type-edit").hide();
});
// Click on 'save' to save new resource type
$(document).on("click", '#save-type', function (event) {
    event.preventDefault();
    if ($("#type").val() !== "") {
        $.get("/CienciasBasicas/ResTypes",
                {
                    action: "add",
                    description: $("#type").val()  
                },
                function (data, status) {
                    $("#type").val("");
                    showTypes();
                    $("#type-input").show();
                    $("#type-edit").hide();
                });
    } else {
        alert("Debe proporcionar valores correctos");
    }
});
//Toggle Enable/Disable button to disable and enable a topic
$(document).on("click", '.enable-rt', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/ResTypes",
            {
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showTypes();
            });
});
// Click on edit to show input for editing a resource type
$(document).on("click", '.edit-rt', function (event) {
    $("#type-edit").show();
    $("#type-input").hide();
    var tmp = $(event.target).parent().parent().siblings(":first").text();
    $("#edit-type").val(tmp);
    $("#update-type").data("id", $(event.target).closest('tr').attr('id'));
});
// Click to update the topic
$(document).on("click", '#update-type', function (event) {
    event.preventDefault();
    if ($("#edit-type").val() !== "") {
        $.get("/CienciasBasicas/ResTypes",
                {
                    action: "update",
                    id: $("#update-type").data('id'),
                    description: $("#edit-type").val()
                },
                function (data, status) {
                    showTypes();
                });
    } else {
        alert("Debe proporcionar valores correctos");
    }
});
/*
 **** ------ END OF TYPES ------ ****
 */
/*
 **** ------ MANAGE AREAS ------ ****
 */
// Function to show areas table
function showAreas() {
    $.get("/CienciasBasicas/Areas",
            {
                action: "show"
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on "Areas" to show areas table
$(document).on("click", '#man-area', function (event) {
    event.preventDefault();
    showAreas();
});
// Click on '+' to show input for new area
$(document).on("click", '#add-area', function (event) {
    $("#area-input").show();
    $("#area-edit").hide();
});
// Click on "save" to save new area
$(document).on("click", '#save-area', function (event) {
    event.preventDefault();
    if ($("#area-name").val() !== "" && $("#area-id").val() !== "") {
        $.get("/CienciasBasicas/Areas",
                {
                    action: "add",
                    area: $("#area-name").val(),
                    id: $("#area-id").val().toUpperCase()
                },
                function (data, status) {
                    $("#area-name").val("");
                    $("#area-id").val("");
                    showAreas();
                    $("#area-input").show();
                    $("#area-edit").hide();
                });
    } else {
        alert("Debe proporcionar valores correctos");
    }
});
//Toggle Enable/Disable button to disable and enable an area
$(document).on("click", '.enable-a', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Areas",
            {
                area: $(event.target).closest('tr').attr('id'),
                action: event.target.getAttribute('name')
            },
            function (data, status) {
                showAreas();
            });
});
// Click on edit to show input for editing an area
$(document).on("click", '.edit-a', function (event) {
    $("#area-edit").show();
    $("#area-input").hide();
    var tmp = $(event.target).parent().parent().siblings(":first").text();
    var tmp2 = $(event.target).parent().parent().siblings(":nth-child(2)").text();
    $("#edit-area").val(tmp);
    $("#update-area").data("id", tmp2);
});
// Click to update the area
$(document).on("click", '#update-area', function (event) {
    event.preventDefault();
    if ($("#edit-area").val() !== "") {
        $.get("/CienciasBasicas/Areas",
                {
                    action: "update",
                    id: $("#update-area").data('id'),
                    area: $("#edit-area").val()
                },
                function (data, status) {
                    showAreas();
                });
    } else {
        alert("Empty");
    }
});
/*
 **** ------ END OF AREAS ------ ****
 */
/*
 **** ------ MANAGE TOPICS ------ ****
 */
// Display list of areas
$(document).on("click", "#man-tas", function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Areas",
            {
                action: "select"
            },
            function (data, status) {
                var x = "";
                for (i in data) {
                    x += "<li><a href=# id='" + data[i].id + "' class='area-link'>" + data[i].area + "</a></li>\n";
                }
                $("#top_sub").html(x);
            });
});
// Function to show topics table
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
// Click on desired 'Area' from 'Temas/Subtemas' to show topics table
$(document).on("click", '.area-link', function (event) {
    event.preventDefault();
    showTopics(event.target.getAttribute('id'));
});
// Click on '+' to show input for new topic
$(document).on("click", '#add-topic', function (event) {
    $("#topic-input").show();
    $("#topic-edit").hide();
});
// Click on 'save' to save new topic
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
        alert("Debe proporcionar valores correctos");
    }
});
//Toggle Enable/Disable button to disable and enable a topic
$(document).on("click", '.enable-t', function (event) {
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
// Click on edit to show input for editing a topic
$(document).on("click", '.edit-t', function (event) {
    $("#topic-edit").show();
    $("#topic-input").hide();
    var tmp = $(event.target).parent().parent().siblings(":first").text();
    var tmp2 = $(event.target).parent().parent().siblings(":nth-child(2)").text();
    $("#edit-topic").val(tmp);
    $("#update-topic").data("id", tmp2);
});
// Click to update the topic
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
        alert("Debe proporcionar valores correctos");
    }
});
/*
 **** ------ END OF TOPICS ------ ****
 */
/*
 **** ------ SUBTOPICS ------ ****
 */
// Function to show subtopics table
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
// Load subtopics table on modal
$(document).on("click", '.modalBtn', function (event) {
    event.preventDefault();
    showSubtopics($(event.target).closest('tr').attr('id'));
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
$(document).on("click", '.enable-s', function (event) {
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
$(document).on("click", '.edit-s', function (event) {
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
        alert("Debe proporcionar valores correctos");
    }
});
/*
 **** ------ END OF SUBTOPICS ------ ****
 */
/*
 **** ------ MANAGE INSTRUCTORS ------ ****
 */
//Function to show instructors table
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
/*
 **** ------ END OF INSTRUCTORS ------ ****
 */
/*
 **** ------ MAANAGE STUDENTS ------ ****
 */
//Show students table
function showStudents() {
    $.get("/CienciasBasicas/Students",
            {
                action: "view",
                mode: "tableStudents",
            },
            function (data, status) {
                $("#cont2").html(data);
            });
}
// Click on students to show students table
$(document).on("click", '#man-stu', function (event) {
    event.preventDefault();
    showStudents();
});
//Enable/Disable an Student
$(document).on("click", '.enable-btn5', function (event) {
    event.preventDefault();
    $.get("/CienciasBasicas/Students",
            {
                action: event.target.getAttribute('name'),
                id: $(event.target).closest('tr').attr('id')
            },
            function (data, status) {
                showStudents();
            });
});
/*
 **** ------ END OF STUDENTS ------ ****
 */
