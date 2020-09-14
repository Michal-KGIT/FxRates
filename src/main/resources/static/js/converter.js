$(document).ready(function () {
    $("#divAlert").hide();
    $("#sourceCurrency").val('EUR');
    $("#targetCurrency").val('AUD');

    $(document).on("click", '#btnConvert', function (event) {
        $("#conversionForm").submit();
    });

    $(document).on("submit", '#conversionForm', function (event) {
        event.preventDefault();

        var $form = $(this);

        $.ajax({
            url: $('#urlConverter').val(),
            data: $form.serializeArray(),
            error: function (xhr, textStatus, error) {
                console.log(xhr.statusText);
                console.log(textStatus);
                console.log(error);
            },
            success: function (data) {
                if (data.error == null) {
                    console.log(data)
                    $('#targetAmount').val(data.convertedValue);
                } else {
                    $('#targetAmount').val("0.00");
                }
            },
            type: 'POST'
        });
    });
});
