(function ($) {

    // 데이터 리스트
    let itemList = new Vue({
        el : '#itemList',
        data : {
            itemList : {}
        }
    });

    $(document).ready(function () {
        searchStart()
    });

    function searchStart() {
        const url = new URL(window.location.href);
        const studentId = url.searchParams.get("studentId");
        $.get(`/v1/student/detail/${studentId}`, function (response) {
            console.log(response.studentDetailList);

            itemList.itemList = response.studentDetailList;

        });
    }
})(jQuery);