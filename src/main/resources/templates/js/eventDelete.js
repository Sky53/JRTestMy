$(function () {
        $("a.deleteCom").on("click", function () {
            var a = $(this);
            $.get($(this).attr("href"), function (data) {
                a.parents(".component-row").empty();
                console.log(data);
            });
            return false;
        });
    }
);

