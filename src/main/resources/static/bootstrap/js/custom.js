$(document).ready(function () {
    $('#inputCity').on('change.bs.select', function () {

        var url = "/api/province/";
        var lstmatinh = $("#inputCity").val();
        $('#inputProvince option').remove();
        $('#inputPX option').remove();
        $('#inputTX option').remove();
        $('#inputProvince').val('');
        $('#inputPX').val('');
        $('#inputTX').val('');

        $.ajax({
            url : url+lstmatinh,
            success : function (data) {
                $('#inputProvince').append($('<option>', {
                    value: "",
                    text: "--Chọn huyện--"
                }));
                $(data).each(function (i, item) {
                    console.log(item);
                    $('#inputProvince').append($('<option>', {
                        value: item["idprovince"],
                        text: item["name"]
                    }));
                });
                $('.selectpicker').selectpicker('refresh');
            }
        });
        return false;
    });

    $('#inputProvince').on('change.bs.select', function () {

        var url = "/api/commune/";
        var id = $("#inputProvince").val();
        $('#inputPX option').remove();
        $('#inputTX option').remove();
        $('#inputPX').val('');
        $('#inputTX').val('');

        $.ajax({
            url : url+id,
            success : function (data) {
                $('#inputPX').append($('<option>', {
                    value: "",
                    text: "--Chọn Phường/Xã--"
                }));
                $(data).each(function (i, item) {
                    console.log(item);
                    $('#inputPX').append($('<option>', {
                        value: item["idcommune"],
                        text: item["commune"]
                    }));
                });
                $('.selectpicker').selectpicker('refresh');
            }
        });
        return false;
    });
    $('#inputPX').on('change.bs.select', function () {

        var url = "/api/hamlet/";
        var id = $("#inputPX").val();
        $('#inputTX option').remove();
        $('#inputTX').val('');

        $.ajax({
            url : url+id,
            success : function (data) {
                $('#inputTX').append($('<option>', {
                    value: "",
                    text: "--Chọn Thôn/Xóm--"
                }));
                $(data).each(function (i, item) {
                    console.log(item);
                    $('#inputTX').append($('<option>', {
                        value: item["idhamlet"],
                        text: item["hamlet"]
                    }));
                });
                $('.selectpicker').selectpicker('refresh');
            }
        });
        return false;
    });
});