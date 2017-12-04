<div style="padding: 15px 0px 0px 10px;">
    <label for="topic">Nuevo tema: </label>
    <input id="profile" value="${topic.id}" type="hidden">
    <input id="area" value="${area}" type="hidden">
    <input id="newTopic" type="text" maxlength="255" value="${topic.name}" required name="topic">
    <a id="updateNow" href="#" class="close-icon"><i class="fa fa-save fa-2x"></i></a>
</div>