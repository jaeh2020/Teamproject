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
		                	"eventName": {
		                		required: !0
		                	},
		                	"eventDetail": {
		                		required: !0
		                	},
		                	"eventStr": {
		                		required: !0
		                	},
		                	"eventFin": { 
		                		required: !0
		                	},
		                	"bannerImg": {
		                		required: !0
		                	},
		                	"img" : {
		                		required: !0
		                	}
		                },
		                messages: {
		                	"eventName":"이벤트명을 입력해주세요",
		                	"eventDetail":"상세설명을 입력해주세요",
		                	"eventStr": "시작일을 선택해주세요",
		                	"eventFin": "종료일을 선택해주세요",
		                	"bannerImg": "파일을 선택해주세요",
		                	"img": "파일을 선택해주세요" 
		                }
		            })
		        }
		    return {
		        init: function() {
		            e(), jQuery(".js-select2").on("change", function() {
		                jQuery(this).valid()
		            });
		        }
		    }
		}();
		jQuery(function() {
		    form_validation.init()
		});