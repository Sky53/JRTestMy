$(function () {
    $(".updateCom").on("click", function () {

        let a = $(this).parents(".component-row").first();
        let id = a.find(".id").first().text();
        let name = a.find(".name").first().text();
        let need = a.find(".need").first().text() === "да";
        let count = a.find(".count").first().text();
        console.log(id, name, need, count);

        $.post("/updates", {id, name, need, count});
        return false;

    });
});
