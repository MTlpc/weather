$(function () {
   $("#selectCityId").change(function () {
       var cityId = $("#selectCityId").val();
       var uri = "/report/cityId/" + cityId;
       window.location.href = uri;
   })
});