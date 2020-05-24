(function ($) {

    const maxBtnSize = 7;              // 검색 하단 최대 범위
    let indexBtn = [];               // 인덱스 버튼
    const pageSize = 10; // 데이터 size

    // 페이징 처리 데이터
    let pagination = {
        total_pages : 0,            // 전체 페이지수
        total_elements : 0,         // 전체 데이터수
        current_page :  0,          // 현재 페이지수
        current_elements : 0        // 현재 데이터수
    };


    // 페이지 정보
    let showPage = new Vue({
        el : '#showPage',
        data : {
            totalElements : {},
            currentPage:{}
        }
    });

    // 데이터 리스트
    let itemList = new Vue({
        el : '#itemList',
        data : {
            itemList : {},
            page : 0
        },
        methods: {
            viewClick: function (studentId) {
                window.open("/pages/student/view?studentId="+studentId, "수강생 상세", 'width=1000, height=400, menubar=no, status=no, toolbar=no, scrollbars=yes');
            }
        }
    });


    // 페이지 버튼 리스트
    let pageBtnList = new Vue({
        el : '#pageBtn',
        data : {
            btnList : {}
        },
        methods: {
            indexClick: function (id) {
                searchStart(id-1)
            },
            previousClick:function () {
                if(pagination.current_page !== 0){
                    searchStart(pagination.current_page-1);
                }
            },
            nextClick:function () {

                if(pagination.current_page !== pagination.total_pages-1){
                    searchStart(pagination.current_page+1);
                }
            }
        },
        mounted:function () {
            // 제일 처음 랜더링 후 색상 처리
            setTimeout(function () {
                $('li[btn_id]').removeClass( "active" );
                $('li[btn_id='+(pagination.current_page+1)+']').addClass( "active" );
            },50)
        }
    });


    $('#search').click(function () {
        searchStart(0)
    });

    $(document).ready(function () {
        searchStart(0)
    });

    function searchStart(index) {
        let url = `/v1/student?page=${index}&size=${pageSize}`
        $.get(url, function (response) {
            console.log(response)
            /* 데이터 셋팅 */
            // 페이징 처리 데이터
            indexBtn = [];
            pagination = response.pagination;


            //전체 페이지
            showPage.totalElements = pagination.currentElements;
            showPage.currentPage = pagination.currentPage+1;


            // 검색 데이터
            itemList.itemList = response.data;
            itemList.page = pagination.currentPage * pageSize;

            // 이전버튼
            if(pagination.currentPage === 0){
                $('#previousBtn').addClass("disabled")
            }else{
                $('#previousBtn').removeClass("disabled")
            }


            // 다음버튼
            if(pagination.currentPage === pagination.totalPages-1){
                $('#nextBtn').addClass("disabled")
            }else{
                $('#nextBtn').removeClass("disabled")
            }

            // 페이징 버튼 처리
            let temp = Math.floor(pagination.currentPage / maxBtnSize);
            for(let i = 1; i <= maxBtnSize; i++){
                let value = i+(temp*maxBtnSize);

                if(value <= pagination.totalPages){
                    indexBtn.push(value)
                }
            }

            // 페이지 버튼 셋팅
            pageBtnList.btnList = indexBtn;


            // 색상처리
            setTimeout(function () {
                $('li[btn_id]').removeClass( "active" );
                $('li[btn_id='+(pagination.currentPage+1)+']').addClass( "active" );
            },50)
        });
    }

    function view(studentId){
        console.log(studentId)
    }

})(jQuery);