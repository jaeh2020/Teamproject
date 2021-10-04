
var form_validation = function() {
    var e = function() {
            jQuery(".form-valide").validate({
                ignore: [],
                errorClass: "invalid-feedback animated fadeInDown",
                errorElement: "div",
                errorPlacement: function(e, a) {
                    jQuery(a).parents(".form-group > div").append(e)
                },
                highlight: function(e) {
                    jQuery(e).closest(".form-group").removeClass("is-invalid").addClass("is-invalid")
                },
                success: function(e) {
                    jQuery(e).closest(".form-group").removeClass("is-invalid"), jQuery(e).remove()
                },
                rules: {
                    "val-username": {
                        required: !0,
                        minlength: 3
                    },
                    "val-email": {
                        required: !0,
                        email: !0
                    },
                    "val-password": {
                        required: !0,
                        minlength: 5
                    },
                    "val-confirm-password": {
                        required: !0,
                        equalTo: "#val-password"
                    },
                    "val-select2": {
                        required: !0
                    },
                    "val-select2-multiple": {
                        required: !0,
                        minlength: 2
                    },
                    "val-suggestions": {
                        required: !0,
                        minlength: 5
                    },
                    "val-skill": {
                        required: !0
                    },
                    "val-currency": {
                        required: !0,
                        currency: ["$", !0]
                    },
                    "val-website": {
                        required: !0,
                        url: !0
                    },
                    "val-phoneus": {
                        required: !0,
                        phoneUS: !0
                    },
                    "val-digits": {
                        required: !0,
                        digits: !0
                    },
                    "val-number": {
                        required: !0,
                        number: !0
                    },
                    "val-range": {
                        required: !0,
                        range: [1, 5]
                    },
                    "val-terms": {
                        required: !0
                    },
                    "storeCode": {
                    	required: !0
                    },
                   /* "menuCode" : {
                    	required: !0
                    },*/
                    "recruitTitle" : {
                    	required: !0
                    },
                    "surveyTitle" : {
                    	required: !0
                    },
                    "ageCodeList" : {
                    	required: !0
                    },
                    "recruitNum" : {
                    	required: !0,
                    	number: !0
                    },
                    "endDate" : {
                    	required: !0
                    },
                    "cateList" : {
                    	required: !0
                    },
                    "specialCateList" : {
                    	required: !0
                    }
                },
                messages: {
                    "val-username": {
                        required: "Please enter a username",
                        minlength: "Your username must consist of at least 3 characters"
                    },
                    "val-email": "Please enter a valid email address",
                    "val-password": {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                    "val-confirm-password": {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long",
                        equalTo: "Please enter the same password as above"
                    },
                    "val-select2": "Please select a value!",
                    "val-select2-multiple": "Please select at least 2 values!",
                    "val-suggestions": "What can we do to become better?",
                    "val-skill": "Please select a skill!",
                    "val-currency": "Please enter a price!",
                    "val-website": "Please enter your website!",
                    "val-phoneus": "Please enter a US phone!",
                    "val-digits": "Please enter only digits!",
                    "val-number": "Please enter a number!",
                    "val-range": "Please enter a number between 1 and 5!",
                    "val-terms": "You must agree to the service terms!",
                    
                    "storeCode": "매장을 선택해주세요!",
                 /*   "menuCode" :"메뉴를 선택해주세요!",*/
                    "recruitTitle": "공고명을 입력해주세요!",
                    "surveyTitle": "설문조사 제목을 입력해주세요!",
                    "ageCodeList": "설문 대상 연령대를 선택해주세요!",
                    "recruitNum": {
                    	 required: "모집 인원을 입력해주세요!",
                    	 number: "숫자만 입력해주세요!"
                    },
                    "endDate": "모집 기한을 선택해주세요!",
                    "cateList": "설문항목을 선택해주세요!",
                    "specialCateList": "분석항목을 선택해주세요!",
                }
            })
        }
    return {
        init: function() {
            e(), jQuery(".js-select2").on("change", function() {
                jQuery(this).valid()
            })
        }
    }
}();
jQuery(function() {
    form_validation.init()
});