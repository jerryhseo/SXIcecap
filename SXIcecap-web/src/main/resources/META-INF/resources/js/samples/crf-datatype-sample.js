let crfSampleDataType = {
    "termValueDelimiter": "=",
    "termDelimiterPosition": true,
    "matrixBracketType": "[]",
    "matrixElementDelimiter": " ",
    "tooltip": {
        "ko_KR": "Data structure 도움말",
        "en_US": "Data structure tooltip"
    },
    "terms": [
        {
            "termType": "Group",
            "termName": "er_init_eval",
            "displayName": {
                "ko_KR": "응급실 초기평가",
                "en_US": "응급실 초기평가"
            },
            "definition": {
                "ko_KR": "ER Initial Evaluation",
                "en_US": "ER Initial Evaluation"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "",
                "en_US": ""
            },
            "synonyms": "ER Initial Evaluation",
            "mandatory": true,
            "order": 1,
            "status": 2,
            "state": 3
        },
        {
            "termType": "Group",
            "termName": "co_profile",
            "displayName": {
                "ko_KR": "CO profile",
                "en_US": "CO profile"
            },
            "definition": {
                "ko_KR": "CO profile",
                "en_US": "CO profile"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "",
                "en_US": ""
            },
            "synonyms": "CO profile",
            "mandatory": true,
            "order": 2,
            "status": 2,
            "state": 3
        },
        {
            "termType": "Group",
            "termName": "in_out_result",
            "displayName": {
                "en_US": "입퇴실결과"
            },
            "definition": {
                "en_US": "In and Out Result"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "In and Out Result",
            "order": 3,
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "abnormal_react",
            "displayName": {
                "en_US": "이상반응"
            },
            "definition": {
                "en_US": "Abnormal Reaction"
            },
            "abstractKey": false,
            "searchable": true,
            "order": 4,
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "clinic",
            "displayName": {
                "en_US": "치료"
            },
            "definition": {
                "en_US": "Clinic"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Clinic"
            },
            "synonyms": "Clinic",
            "order": 5,
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "rehabilitation_test",
            "displayName": {
                "en_US": "재활의학과 검사"
            },
            "definition": {
                "en_US": "Rehabilitation Test"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Rehabilitation Test"
            },
            "synonyms": "Rehabilitation Test",
            "order": 6,
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "total_test",
            "displayName": {
                "en_US": "통합검사"
            },
            "definition": {
                "en_US": "Total Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 7,
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "image_exam",
            "displayName": {
                "en_US": "영상검사"
            },
            "definition": {
                "en_US": "Image Examination"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Image Examination",
            "order": 8,
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "abnormal_react_out",
            "displayName": {
                "en_US": "퇴원 후 이상반응"
            },
            "definition": {
                "en_US": "Abnormal Reaction after discharged"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Abnormal Reaction after discharged",
            "order": 9,
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "nephrology_study",
            "displayName": {
                "en_US": "신장내과 연구"
            },
            "definition": {
                "en_US": "신장내과 연구"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "신장내과 연구"
            },
            "synonyms": "Nephrology study",
            "order": 10,
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "ae_out",
            "displayName": {
                "en_US": "퇴원 후 AE"
            },
            "definition": {
                "en_US": "AE after discharged"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Abnormal Reaction after discharged",
            "order": 1,
            "groupTermId": {
                "name": "abnormal_react_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "cardiology_out",
            "displayName": {
                "en_US": "퇴원 후 심장내과 외래"
            },
            "definition": {
                "en_US": "Cadiology after discharged"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Abnormal Reaction after discharged",
            "order": 2,
            "groupTermId": {
                "name": "abnormal_react_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "echocardiography_out",
            "displayName": {
                "en_US": "퇴원 후 심장초음파"
            },
            "definition": {
                "en_US": "Echocardiography after discharged"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Abnormal Reaction after discharged",
            "order": 3,
            "groupTermId": {
                "name": "abnormal_react_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "passing_out",
            "displayName": {
                "en_US": "퇴원 후 사망여부"
            },
            "definition": {
                "en_US": "Passing after leave Hospital"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Abnormal Reaction after discharged",
            "order": 4,
            "groupTermId": {
                "name": "abnormal_react_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "final_neurologic",
            "displayName": {
                "en_US": "Final neurologic outcome"
            },
            "definition": {
                "en_US": "Final neurologic outcome"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Abnormal Reaction after discharged",
            "order": 5,
            "groupTermId": {
                "name": "abnormal_react_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Numeric",
            "termName": "pttsec",
            "displayName": {
                "en_US": "PTTsec"
            },
            "definition": {
                "en_US": "PTTsec"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "PTTsec"
            },
            "synonyms": "Total Test",
            "order": 1,
            "groupTermId": {
                "name": "throm_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.0",
            "maxValue": "40.0",
            "unit": "sec",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "pt_inr",
            "displayName": {
                "en_US": "PT INR"
            },
            "definition": {
                "en_US": "PT INR"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "PT INR"
            },
            "synonyms": "Total Test",
            "order": 2,
            "groupTermId": {
                "name": "throm_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.80",
            "maxValue": "15.0",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "fdp",
            "displayName": {
                "en_US": "FDP"
            },
            "definition": {
                "en_US": "FDP"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "FDP"
            },
            "synonyms": "Total Test",
            "order": 3,
            "groupTermId": {
                "name": "throm_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.0",
            "maxValue": "50.0",
            "unit": "μg/mL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "d_dimer",
            "displayName": {
                "en_US": "D-dimer"
            },
            "definition": {
                "en_US": "D-dimer"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "D-dimer"
            },
            "synonyms": "Total Test",
            "order": 4,
            "groupTermId": {
                "name": "throm_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 0.1,
            "maxValue": "10000.0",
            "unit": "ng/mL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "at_3",
            "displayName": {
                "en_US": "AT-Ⅲ"
            },
            "definition": {
                "en_US": "AT-Ⅲ"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "AT-Ⅲ"
            },
            "synonyms": "Total Test",
            "order": 5,
            "groupTermId": {
                "name": "throm_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "11.0",
            "maxValue": "130.0",
            "unit": "% activity",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "fibrinogen",
            "displayName": {
                "en_US": "Fibrinogen"
            },
            "definition": {
                "en_US": "Fibrinogen"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Fibrinogen"
            },
            "synonyms": "Total Test",
            "order": 6,
            "groupTermId": {
                "name": "throm_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "30.0",
            "maxValue": "700.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "wbc_0",
            "displayName": {
                "en_US": "WBC#0"
            },
            "definition": {
                "en_US": "WBC#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "WBC#0"
            },
            "synonyms": "Total Test",
            "order": 1,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "2.00",
            "maxValue": "30.00",
            "unit": "E9/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "hb_0",
            "displayName": {
                "en_US": "Hb#0"
            },
            "definition": {
                "en_US": "Hb#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Hb#0"
            },
            "synonyms": "Total Test",
            "order": 2,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "4.0",
            "maxValue": "15.0",
            "unit": "g/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "hct_0",
            "displayName": {
                "en_US": "Hct#0"
            },
            "definition": {
                "en_US": "Hct#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Hct#0"
            },
            "synonyms": "Total Test",
            "order": 3,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "20.0",
            "maxValue": "50.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "plt_0",
            "displayName": {
                "en_US": "Plt#0"
            },
            "definition": {
                "en_US": "Plt#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Plt#0"
            },
            "synonyms": "Total Test",
            "order": 4,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 100,
            "maxValue": "400",
            "unit": "E9/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "dni_0",
            "displayName": {
                "en_US": "DNI#0"
            },
            "definition": {
                "en_US": "DNI#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "DNI#0"
            },
            "synonyms": "Total Test",
            "order": 5,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 0.1,
            "maxValue": "30.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "mpxi_0",
            "displayName": {
                "en_US": "MPXI#0"
            },
            "definition": {
                "en_US": "MPXI#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MPXI#0"
            },
            "synonyms": "Total Test",
            "order": 6,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "-10.0",
            "maxValue": "10.0",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "neutropil_0",
            "displayName": {
                "en_US": "Neutropil#0"
            },
            "definition": {
                "en_US": "Neutropil#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Neutropil#0"
            },
            "synonyms": "Total Test",
            "order": 7,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.50",
            "maxValue": "80.00",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "lymphocyte_0",
            "displayName": {
                "en_US": "Lymphocyte#0"
            },
            "definition": {
                "en_US": "Lymphocyte#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Lymphocyte#0"
            },
            "synonyms": "Total Test",
            "order": 8,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.10",
            "maxValue": "40.00",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "monocyte_0",
            "displayName": {
                "en_US": "Monocyte#0"
            },
            "definition": {
                "en_US": "Monocyte#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Monocyte#0"
            },
            "synonyms": "Total Test",
            "order": 9,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 0.01,
            "maxValue": "5.00",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "wbc_1",
            "displayName": {
                "en_US": "WBC#1"
            },
            "definition": {
                "en_US": "WBC#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "WBC#1"
            },
            "synonyms": "Total Test",
            "order": 10,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "2.00",
            "maxValue": "30.00",
            "unit": "E9/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "hb_1",
            "displayName": {
                "en_US": "Hb#1"
            },
            "definition": {
                "en_US": "Hb#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Hb#1"
            },
            "synonyms": "Total Test",
            "order": 11,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "4.0",
            "maxValue": "15.0",
            "unit": "g/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "hct_1",
            "displayName": {
                "en_US": "Hct#1"
            },
            "definition": {
                "en_US": "Hct#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Hct#1"
            },
            "synonyms": "Total Test",
            "order": 12,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "20.0",
            "maxValue": "50.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "plt_1",
            "displayName": {
                "en_US": "Plt#1"
            },
            "definition": {
                "en_US": "Plt#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Plt#1"
            },
            "synonyms": "Total Test",
            "order": 13,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 100,
            "maxValue": "400",
            "unit": "E9/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "dni_1",
            "displayName": {
                "en_US": "DNI#1"
            },
            "definition": {
                "en_US": "DNI#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "DNI#1"
            },
            "synonyms": "Total Test",
            "order": 14,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 0.1,
            "maxValue": "30.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "mpxi_1",
            "displayName": {
                "en_US": "MPXI#1"
            },
            "definition": {
                "en_US": "MPXI#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MPXI#1"
            },
            "synonyms": "Total Test",
            "order": 15,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "-10.0",
            "maxValue": "10.0",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "nrl_0",
            "displayName": {
                "en_US": "Neutrophil-lymphocyte ratio (NLR) #0"
            },
            "definition": {
                "en_US": "Neutrophil-lymphocyte ratio (NLR) #0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Neutrophil-lymphocyte ratio (NLR) #0"
            },
            "synonyms": "Total Test",
            "order": 16,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "800.00",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "mlr_0",
            "displayName": {
                "en_US": "Monocyte-lyphocyte ratio (MLR) #0"
            },
            "definition": {
                "en_US": "Monocyte-lyphocyte ratio (MLR) #0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Monocyte-lyphocyte ratio (MLR) #0"
            },
            "synonyms": "Total Test",
            "order": 17,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "5.00",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "plr_0",
            "displayName": {
                "en_US": "Platelet-lymphocyte ratio (PLR) #0"
            },
            "definition": {
                "en_US": "Platelet-lymphocyte ratio (PLR) #0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Platelet-lymphocyte ratio (PLR) #0"
            },
            "synonyms": "Total Test",
            "order": 18,
            "groupTermId": {
                "name": "blood_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "600.00",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "s_100",
            "displayName": {
                "en_US": "S-100"
            },
            "definition": {
                "en_US": "S-100"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "S-100"
            },
            "synonyms": "Total Test",
            "order": 1,
            "groupTermId": {
                "name": "imm_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "0.50",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "nse",
            "displayName": {
                "en_US": "NSE"
            },
            "definition": {
                "en_US": "NSE"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "NSE"
            },
            "synonyms": "Total Test",
            "order": 2,
            "groupTermId": {
                "name": "imm_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "9.0",
            "maxValue": "100.0",
            "unit": "ng/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ck_mb_0",
            "displayName": {
                "en_US": "CK-MB#0"
            },
            "definition": {
                "en_US": "CK-MB#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CK-MB#0"
            },
            "synonyms": "Total Test",
            "order": 1,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "100.00",
            "unit": "ng/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tni_0",
            "displayName": {
                "en_US": "TnI#0"
            },
            "definition": {
                "en_US": "TnI#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TnI#0"
            },
            "synonyms": "Total Test",
            "order": 2,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "50000.00",
            "unit": "pg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "myoglobin_0",
            "displayName": {
                "en_US": "Myoglobin#0"
            },
            "definition": {
                "en_US": "Myoglobin#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Myoglobin#0"
            },
            "synonyms": "Total Test",
            "order": 3,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "3.00",
            "maxValue": "1000.00",
            "unit": "pg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ck_mb_1",
            "displayName": {
                "en_US": "CK-MB#1"
            },
            "definition": {
                "en_US": "CK-MB#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CK-MB#1"
            },
            "synonyms": "Total Test",
            "order": 4,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "100.00",
            "unit": "ng/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tni_1",
            "displayName": {
                "en_US": "TnI#1"
            },
            "definition": {
                "en_US": "TnI#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TnI#1"
            },
            "synonyms": "Total Test",
            "order": 5,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "50000.00",
            "unit": "pg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ck_mb_2",
            "displayName": {
                "en_US": "CK-MB#2"
            },
            "definition": {
                "en_US": "CK-MB#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CK-MB#2"
            },
            "synonyms": "Total Test",
            "order": 6,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "100.00",
            "unit": "ng/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tni_2",
            "displayName": {
                "en_US": "TnI#2"
            },
            "definition": {
                "en_US": "TnI#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TnI#2"
            },
            "synonyms": "Total Test",
            "order": 7,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "50000.00",
            "unit": "pg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "peak_tni",
            "displayName": {
                "en_US": "Peak TnI"
            },
            "definition": {
                "en_US": "Peak TnI"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Peak TnI"
            },
            "synonyms": "Total Test",
            "order": 8,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "50000.00",
            "unit": "pg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "bnp",
            "displayName": {
                "en_US": "BNP"
            },
            "definition": {
                "en_US": "BNP"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "BNP"
            },
            "synonyms": "Total Test",
            "order": 9,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "1000.00",
            "unit": "pg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "pro_bnp",
            "displayName": {
                "en_US": "pro BNP"
            },
            "definition": {
                "en_US": "pro BNP"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "pro BNP"
            },
            "synonyms": "Total Test",
            "order": 10,
            "groupTermId": {
                "name": "heart_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "1000.00",
            "unit": "pg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "crp_0",
            "displayName": {
                "en_US": "CRP#0"
            },
            "definition": {
                "en_US": "CRP#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CRP#0"
            },
            "synonyms": "Total Test",
            "order": 1,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "20.00",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "glucose_0",
            "displayName": {
                "en_US": "Glucose#0"
            },
            "definition": {
                "en_US": "Glucose#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Glucose#0"
            },
            "synonyms": "Total Test",
            "order": 2,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 40,
            "maxValue": "300",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "albumine_0",
            "displayName": {
                "en_US": "Albumine#0"
            },
            "definition": {
                "en_US": "Albumine#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Albumine#0"
            },
            "synonyms": "Total Test",
            "order": 3,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "2.0",
            "maxValue": "5.0",
            "unit": "g/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "s_na_0",
            "displayName": {
                "en_US": "S_Na#0"
            },
            "definition": {
                "en_US": "S_Na#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "S_Na#0"
            },
            "synonyms": "Total Test",
            "order": 4,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 120,
            "maxValue": "160",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "s_k_0",
            "displayName": {
                "en_US": "S_K#0"
            },
            "definition": {
                "en_US": "S_K#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "S_K#0"
            },
            "synonyms": "Total Test",
            "order": 5,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "2.0",
            "maxValue": "6.0",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "fena_0",
            "displayName": {
                "en_US": "FENA#0"
            },
            "definition": {
                "en_US": "FENA#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "FENA#0"
            },
            "synonyms": "Total Test",
            "order": 6,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "10.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "cystatin_c_0",
            "displayName": {
                "en_US": "Cystatin C#0"
            },
            "definition": {
                "en_US": "Cystatin C#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Cystatin C#0"
            },
            "synonyms": "Total Test",
            "order": 7,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "1.00",
            "unit": "mg/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "rbc_dys_0",
            "displayName": {
                "en_US": "RBC dys#0"
            },
            "definition": {
                "en_US": "RBC dys#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "RBC dys#0"
            },
            "synonyms": "Total Test",
            "order": 8,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 10,
            "maxValue": "30",
            "unit": "HPF",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "ur_myoglo_0",
            "displayName": {
                "en_US": "Ur_myoglo#0"
            },
            "definition": {
                "en_US": "Ur_myoglo#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Ur_myoglo#0"
            },
            "synonyms": "Total Test",
            "order": 9,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "negative"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "positive"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "ast_0",
            "displayName": {
                "en_US": "AST#0"
            },
            "definition": {
                "en_US": "AST#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "AST#0"
            },
            "synonyms": "Total Test",
            "order": 10,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 10,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "alt_0",
            "displayName": {
                "en_US": "ALT#0"
            },
            "definition": {
                "en_US": "ALT#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALT#0"
            },
            "synonyms": "Total Test",
            "order": 11,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 10,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "r_gt_0",
            "displayName": {
                "en_US": "r-GT #0"
            },
            "definition": {
                "en_US": "r-GT #0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "r-GT #0"
            },
            "synonyms": "Total Test",
            "order": 12,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 30,
            "maxValue": "100",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "alp_0",
            "displayName": {
                "en_US": "ALP#0"
            },
            "definition": {
                "en_US": "ALP#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALP#0"
            },
            "synonyms": "Total Test",
            "order": 13,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "20",
            "maxValue": "300",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tb_0",
            "displayName": {
                "en_US": "TB#0"
            },
            "definition": {
                "en_US": "TB#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TB#0"
            },
            "synonyms": "Total Test",
            "order": 14,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.10",
            "maxValue": "7.00",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "db_0",
            "displayName": {
                "en_US": "DB#0"
            },
            "definition": {
                "en_US": "DB#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "DB#0"
            },
            "synonyms": "Total Test",
            "order": 15,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "1.50",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ca_0",
            "displayName": {
                "en_US": "Ca#0"
            },
            "definition": {
                "en_US": "Ca#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Ca#0"
            },
            "synonyms": "Total Test",
            "order": 16,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "5.0",
            "maxValue": "12.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "p_0",
            "displayName": {
                "en_US": "P#0"
            },
            "definition": {
                "en_US": "P#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "P#0"
            },
            "synonyms": "Total Test",
            "order": 17,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 0.5,
            "maxValue": "10.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "bun_0",
            "displayName": {
                "en_US": "BUN#0"
            },
            "definition": {
                "en_US": "BUN#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "BUN#0"
            },
            "synonyms": "Total Test",
            "order": 18,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "3.0",
            "maxValue": "30.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "cr_0",
            "displayName": {
                "en_US": "Cr#0"
            },
            "definition": {
                "en_US": "Cr#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Cr#0"
            },
            "synonyms": "Total Test",
            "order": 19,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.10",
            "maxValue": "6.00",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ck_0",
            "displayName": {
                "en_US": "CK#0"
            },
            "definition": {
                "en_US": "CK#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CK#0"
            },
            "synonyms": "Total Test",
            "order": 20,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "5000",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ldh_0",
            "displayName": {
                "en_US": "LDH#0"
            },
            "definition": {
                "en_US": "LDH#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "LDH#0"
            },
            "synonyms": "Total Test",
            "order": 21,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "1000",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ast_1",
            "displayName": {
                "en_US": "AST#1"
            },
            "definition": {
                "en_US": "AST#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "AST#1"
            },
            "synonyms": "Total Test",
            "order": 22,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 10,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "peak_ck_2day",
            "displayName": {
                "en_US": "peak Ck_2days"
            },
            "definition": {
                "en_US": "peak Ck_2days"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "peak Ck_2days"
            },
            "synonyms": "Total Test",
            "order": 23,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "5000",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "lipase_0",
            "displayName": {
                "en_US": "Lipase#0"
            },
            "definition": {
                "en_US": "Lipase#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Lipase#0"
            },
            "synonyms": "Total Test",
            "order": 24,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "alt_1",
            "displayName": {
                "en_US": "ALT#1"
            },
            "definition": {
                "en_US": "ALT#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALT#1"
            },
            "synonyms": "Total Test",
            "order": 25,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 10,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "amylase_0",
            "displayName": {
                "en_US": "Amylase#0"
            },
            "definition": {
                "en_US": "Amylase#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Amylase#0"
            },
            "synonyms": "Total Test",
            "order": 26,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 5,
            "maxValue": "600",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "r_gt_1",
            "displayName": {
                "en_US": "r-GT #1"
            },
            "definition": {
                "en_US": "r-GT #1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "r-GT #1"
            },
            "synonyms": "Total Test",
            "order": 27,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 30,
            "maxValue": "100",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "alp_1",
            "displayName": {
                "en_US": "ALP#1"
            },
            "definition": {
                "en_US": "ALP#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALP#1"
            },
            "synonyms": "Total Test",
            "order": 28,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 30,
            "maxValue": "300",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tb_1",
            "displayName": {
                "en_US": "TB#1"
            },
            "definition": {
                "en_US": "TB#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TB#1"
            },
            "synonyms": "Total Test",
            "order": 29,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.10",
            "maxValue": "7.00",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "db_1",
            "displayName": {
                "en_US": "DB#1"
            },
            "definition": {
                "en_US": "DB#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "DB#1"
            },
            "synonyms": "Total Test",
            "order": 30,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "1.50",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ca_1",
            "displayName": {
                "en_US": "Ca#1"
            },
            "definition": {
                "en_US": "Ca#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Ca#1"
            },
            "synonyms": "Total Test",
            "order": 31,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "5.0",
            "maxValue": "12.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "p_1",
            "displayName": {
                "en_US": "P#1"
            },
            "definition": {
                "en_US": "P#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "P#1"
            },
            "synonyms": "Total Test",
            "order": 32,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 0.5,
            "maxValue": "10.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "bun_1",
            "displayName": {
                "en_US": "BUN#1"
            },
            "definition": {
                "en_US": "BUN#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "BUN#1"
            },
            "synonyms": "Total Test",
            "order": 33,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "3.0",
            "maxValue": "30.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "cr_1",
            "displayName": {
                "en_US": "Cr#1"
            },
            "definition": {
                "en_US": "Cr#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Cr#1"
            },
            "synonyms": "Total Test",
            "order": 34,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.10",
            "maxValue": "6.00",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ck_1",
            "displayName": {
                "en_US": "CK#1"
            },
            "definition": {
                "en_US": "CK#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CK#1"
            },
            "synonyms": "Total Test",
            "order": 35,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "5000",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ldh_1",
            "displayName": {
                "en_US": "LDH#1"
            },
            "definition": {
                "en_US": "LDH#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "LDH#1"
            },
            "synonyms": "Total Test",
            "order": 36,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "1000",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "lipase_1",
            "displayName": {
                "en_US": "Lipase#1"
            },
            "definition": {
                "en_US": "Lipase#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Lipase#1"
            },
            "synonyms": "Total Test",
            "order": 37,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "amylase_1",
            "displayName": {
                "en_US": "Amylase#1"
            },
            "definition": {
                "en_US": "Amylase#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Amylase#1"
            },
            "synonyms": "Total Test",
            "order": 38,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 5,
            "maxValue": "600",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ast_2",
            "displayName": {
                "en_US": "AST#2"
            },
            "definition": {
                "en_US": "AST#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "AST#2"
            },
            "synonyms": "Total Test",
            "order": 39,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 10,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "alt_2",
            "displayName": {
                "en_US": "ALT#2"
            },
            "definition": {
                "en_US": "ALT#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALT#2"
            },
            "synonyms": "Total Test",
            "order": 40,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 10,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "r_gt_2",
            "displayName": {
                "en_US": "r-GT #2"
            },
            "definition": {
                "en_US": "r-GT #2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "r-GT #2"
            },
            "synonyms": "Total Test",
            "order": 41,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 30,
            "maxValue": "100",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "alp_2",
            "displayName": {
                "en_US": "ALP#2"
            },
            "definition": {
                "en_US": "ALP#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALP#2"
            },
            "synonyms": "Total Test",
            "order": 42,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 30,
            "maxValue": "300",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tb_2",
            "displayName": {
                "en_US": "TB#2"
            },
            "definition": {
                "en_US": "TB#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TB#2"
            },
            "synonyms": "Total Test",
            "order": 43,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.10",
            "maxValue": "7.00",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "db_2",
            "displayName": {
                "en_US": "DB#2"
            },
            "definition": {
                "en_US": "DB#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "DB#2"
            },
            "synonyms": "Total Test",
            "order": 44,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.00",
            "maxValue": "1.50",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ca_2",
            "displayName": {
                "en_US": "Ca#2"
            },
            "definition": {
                "en_US": "Ca#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Ca#2"
            },
            "synonyms": "Total Test",
            "order": 45,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "5.0",
            "maxValue": "12.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "p_2",
            "displayName": {
                "en_US": "P#2"
            },
            "definition": {
                "en_US": "P#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "P#2"
            },
            "synonyms": "Total Test",
            "order": 46,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 0.5,
            "maxValue": "10.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "bun_2",
            "displayName": {
                "en_US": "BUN#2"
            },
            "definition": {
                "en_US": "BUN#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "BUN#2"
            },
            "synonyms": "Total Test",
            "order": 47,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "3.0",
            "maxValue": "30.0",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "cr_2",
            "displayName": {
                "en_US": "Cr#2"
            },
            "definition": {
                "en_US": "Cr#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Cr#2"
            },
            "synonyms": "Total Test",
            "order": 48,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.10",
            "maxValue": "6.00",
            "unit": "mg/dL",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ck_2",
            "displayName": {
                "en_US": "CK#2"
            },
            "definition": {
                "en_US": "CK#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CK#2"
            },
            "synonyms": "Total Test",
            "order": 49,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "5000",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ldh_2",
            "displayName": {
                "en_US": "LDH#2"
            },
            "definition": {
                "en_US": "LDH#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "LDH#2"
            },
            "synonyms": "Total Test",
            "order": 50,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "1000",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "lipase_2",
            "displayName": {
                "en_US": "Lipase#2"
            },
            "definition": {
                "en_US": "Lipase#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Lipase#2"
            },
            "synonyms": "Total Test",
            "order": 51,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 15,
            "maxValue": "500",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "amylase_2",
            "displayName": {
                "en_US": "Amylase#2"
            },
            "definition": {
                "en_US": "Amylase#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Amylase#2"
            },
            "synonyms": "Total Test",
            "order": 52,
            "groupTermId": {
                "name": "chem_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 5,
            "maxValue": "600",
            "unit": "U/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "co_hb_before",
            "displayName": {
                "en_US": "CO-Hb(내원 전 병원)"
            },
            "definition": {
                "en_US": "CO-Hb(내원 전 병원)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CO-Hb(내원 전 병원)"
            },
            "synonyms": "Total Test",
            "order": 1,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.0",
            "maxValue": "70.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "co_hb_0",
            "displayName": {
                "en_US": "CO-Hb#0"
            },
            "definition": {
                "en_US": "CO-Hb#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CO-Hb#0"
            },
            "synonyms": "Total Test",
            "order": 2,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.0",
            "maxValue": "70.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ph_0",
            "displayName": {
                "en_US": "pH#0"
            },
            "definition": {
                "en_US": "pH#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "pH#0"
            },
            "synonyms": "Total Test",
            "order": 3,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "6.0",
            "maxValue": "8.0",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "po2_0",
            "displayName": {
                "en_US": "PO₂#0"
            },
            "definition": {
                "en_US": "PO₂#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "PO₂#0"
            },
            "synonyms": "Total Test",
            "order": 4,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "40.0",
            "maxValue": "600.0",
            "unit": "mmHg",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "pco2_0",
            "displayName": {
                "en_US": "PCO₂#0"
            },
            "definition": {
                "en_US": "PCO₂#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "PCO₂#0"
            },
            "synonyms": "Total Test",
            "order": 5,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "9.0",
            "maxValue": "80.0",
            "unit": "mmHg",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "sao2_0",
            "displayName": {
                "en_US": "SaO₂#0"
            },
            "definition": {
                "en_US": "SaO₂#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "SaO₂#0"
            },
            "synonyms": "Total Test",
            "order": 6,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "17.0",
            "maxValue": "100.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "be_0",
            "displayName": {
                "en_US": "BE#0"
            },
            "definition": {
                "en_US": "BE#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "BE#0"
            },
            "synonyms": "Total Test",
            "order": 7,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "-40.0",
            "maxValue": "10.0",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "hco3_0",
            "displayName": {
                "en_US": "HCO₃#0"
            },
            "definition": {
                "en_US": "HCO₃#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "HCO₃#0"
            },
            "synonyms": "Total Test",
            "order": 8,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "5.0",
            "maxValue": "30.0",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ion_ca_0",
            "displayName": {
                "en_US": "Ionized Ca++#0"
            },
            "definition": {
                "en_US": "Ionized Ca++#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Ionized Ca++#0"
            },
            "synonyms": "Total Test",
            "order": 9,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": 0.25,
            "maxValue": "1.0",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "lactate_0",
            "displayName": {
                "en_US": "Lactate#0"
            },
            "definition": {
                "en_US": "Lactate#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Lactate#0"
            },
            "synonyms": "Total Test",
            "order": 10,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.30",
            "maxValue": "10.00",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "co_hb_1",
            "displayName": {
                "en_US": "CO-Hb#1"
            },
            "definition": {
                "en_US": "CO-Hb#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CO-Hb#1"
            },
            "synonyms": "Total Test",
            "order": 11,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.0",
            "maxValue": "70.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "ph_1",
            "displayName": {
                "en_US": "pH#1"
            },
            "definition": {
                "en_US": "pH#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "pH#1"
            },
            "synonyms": "Total Test",
            "order": 12,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "6.000",
            "maxValue": "8.000",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "po2_1",
            "displayName": {
                "en_US": "PO₂#1"
            },
            "definition": {
                "en_US": "PO₂#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "PO₂#1"
            },
            "synonyms": "Total Test",
            "order": 13,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "40.0",
            "maxValue": "600.0",
            "unit": "mmHg",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "pco2_1",
            "displayName": {
                "en_US": "PCO₂#1"
            },
            "definition": {
                "en_US": "PCO₂#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "PCO₂#1"
            },
            "synonyms": "Total Test",
            "order": 14,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "9.0",
            "maxValue": "80.0",
            "unit": "mmHg",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "sao2_1",
            "displayName": {
                "en_US": "SaO₂#1"
            },
            "definition": {
                "en_US": "SaO₂#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "SaO₂#1"
            },
            "synonyms": "Total Test",
            "order": 15,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "17.0",
            "maxValue": "100.0",
            "unit": "%",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "be_1",
            "displayName": {
                "en_US": "BE#1"
            },
            "definition": {
                "en_US": "BE#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "BE#1"
            },
            "synonyms": "Total Test",
            "order": 16,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "-40.0",
            "maxValue": "10.0",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "hco3_1",
            "displayName": {
                "en_US": "HCO₃#1"
            },
            "definition": {
                "en_US": "HCO₃#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "HCO₃#1"
            },
            "synonyms": "Total Test",
            "order": 17,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "5.0",
            "maxValue": "30.0",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "lactate_1",
            "displayName": {
                "en_US": "Lactate#1"
            },
            "definition": {
                "en_US": "Lactate#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Lactate#1"
            },
            "synonyms": "Total Test",
            "order": 18,
            "groupTermId": {
                "name": "arterial_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "minValue": "0.30",
            "maxValue": "10.00",
            "unit": "mmol/L",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "berg_balance_test",
            "displayName": {
                "en_US": "균형평가-Berg Balance Test"
            },
            "definition": {
                "en_US": "균형평가-Berg Balance Test"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "균형평가-Berg Balance Test"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "modified_mas",
            "displayName": {
                "en_US": "Modified MAS (motor assessment scale)"
            },
            "definition": {
                "en_US": "Modified MAS (motor assessment scale)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Modified MAS (motor assessment scale)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "joint_working_range_test",
            "displayName": {
                "en_US": "사지 관절가동범위 검사"
            },
            "definition": {
                "en_US": "사지 관절가동범위 검사"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "사지 관절가동범위 검사"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "mannual_mussle_test",
            "displayName": {
                "en_US": "도수근력검사-Mannual Musle Test (MMT)"
            },
            "definition": {
                "en_US": "도수근력검사-Mannual Musle Test (MMT)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "도수근력검사-Mannual Musle Test (MMT)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 4,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "hand_grip_power",
            "displayName": {
                "en_US": "Hand Grip Power & Dexterity"
            },
            "definition": {
                "en_US": "Hand Grip Power & Dexterity"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Hand Grip Power & Dexterity"
            },
            "synonyms": "Rehabilitation Test",
            "order": 5,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "hand_function_test",
            "displayName": {
                "en_US": "Jebsen-Taylor Hand Function Test"
            },
            "definition": {
                "en_US": "Jebsen-Taylor Hand Function Test"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Jebsen-Taylor Hand Function Test"
            },
            "synonyms": "Rehabilitation Test",
            "order": 6,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "handle_test",
            "displayName": {
                "en_US": "손잡이검사"
            },
            "definition": {
                "en_US": "손잡이검사"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "손잡이검사"
            },
            "synonyms": "Rehabilitation Test",
            "order": 7,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "card_sorting_test",
            "displayName": {
                "en_US": "위스콘신 카드분류검사"
            },
            "definition": {
                "en_US": "위스콘신 카드분류검사"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "위스콘신 카드분류검사"
            },
            "synonyms": "Rehabilitation Test",
            "order": 8,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "apraxia_test",
            "displayName": {
                "en_US": "실행증검사"
            },
            "definition": {
                "en_US": "실행증검사"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "실행증검사"
            },
            "synonyms": "Rehabilitation Test",
            "order": 9,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "organize_test",
            "displayName": {
                "en_US": "구성능력검사"
            },
            "definition": {
                "en_US": "구성능력검사"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "구성능력검사"
            },
            "synonyms": "Rehabilitation Test",
            "order": 10,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "lotca_test",
            "displayName": {
                "en_US": "LOTCA Battery: Scoring sheet"
            },
            "definition": {
                "en_US": "LOTCA Battery: Scoring sheet"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "LOTCA Battery: Scoring sheet"
            },
            "synonyms": "Rehabilitation Test",
            "order": 11,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "fugl_meyer",
            "displayName": {
                "en_US": "Fugl-Meyer"
            },
            "definition": {
                "en_US": "Fugl-Meyer"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Fugl-Meyer"
            },
            "synonyms": "Rehabilitation Test",
            "order": 12,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "cognitive_test",
            "displayName": {
                "en_US": "인식력검사"
            },
            "definition": {
                "en_US": "인식력검사"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "인식력검사"
            },
            "synonyms": "Rehabilitation Test",
            "order": 13,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "vfss",
            "displayName": {
                "en_US": "비디오 연하 조영 검사-VFSS"
            },
            "definition": {
                "en_US": "비디오 연하 조영 검사-VFSS"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "비디오 연하 조영 검사-VFSS"
            },
            "synonyms": "Rehabilitation Test",
            "order": 14,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "mvpt",
            "displayName": {
                "en_US": "MVPT-Motor Free Visual Perception Test"
            },
            "definition": {
                "en_US": "MVPT-Motor Free Visual Perception Test"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MVPT-Motor Free Visual Perception Test"
            },
            "synonyms": "Rehabilitation Test",
            "order": 15,
            "groupTermId": {
                "name": "reh_opd_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "dns_out_deteriorated",
            "displayName": {
                "en_US": "DNS 퇴원시점보다 악화"
            },
            "definition": {
                "en_US": "DNS 퇴원시점보다 악화"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "DNS 퇴원시점보다 악화"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "neurologic_seq",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "unknown"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "pns_under_4",
            "displayName": {
                "en_US": "PNS 4점 이하 sequelae"
            },
            "definition": {
                "en_US": "PNS 4점 이하 sequelae"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "PNS 4점 이하 sequelae"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "neurologic_seq",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "unknown"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "short_term_mem_test_sight",
            "displayName": {
                "en_US": "단기기억력검사(시각)[정방향/역방향]"
            },
            "definition": {
                "en_US": "단기기억력검사(시각)[정방향/역방향]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "단기기억력검사(시각)[정방향/역방향]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "mem_think_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "String",
            "termName": "short_term_mem_test_hearing",
            "displayName": {
                "en_US": "단기기억력검사(청각)[정방향/역방향]"
            },
            "definition": {
                "en_US": "단기기억력검사(청각)[정방향/역방향]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "단기기억력검사(청각)[정방향/역방향]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "mem_think_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "Numeric",
            "termName": "logical_test",
            "displayName": {
                "en_US": "논리적사고력검사"
            },
            "definition": {
                "en_US": "논리적사고력검사"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "논리적사고력검사"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "mem_think_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "clock_drawing",
            "displayName": {
                "en_US": "시계그리기"
            },
            "definition": {
                "en_US": "시계그리기"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "시계그리기"
            },
            "synonyms": "Rehabilitation Test",
            "order": 4,
            "groupTermId": {
                "name": "mem_think_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "trail_making_min",
            "displayName": {
                "en_US": "Trail making (minutes)"
            },
            "definition": {
                "en_US": "Trail making (minutes)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Trail making (minutes)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "trail_making",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tail_making_error",
            "displayName": {
                "en_US": "Trail making (Errors)"
            },
            "definition": {
                "en_US": "Trail making (Errors)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Trail making (Errors)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "trail_making",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "finger_tapping",
            "displayName": {
                "en_US": "finger tapping(Lt/Rt)"
            },
            "definition": {
                "en_US": "finger tapping(Lt/Rt)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "finger tapping(Lt/Rt)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "trail_making",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "word_reading",
            "displayName": {
                "en_US": "Word_Reading"
            },
            "definition": {
                "en_US": "Word_Reading"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Word_Reading"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "stroop_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "color_reading",
            "displayName": {
                "en_US": "Color_Reading"
            },
            "definition": {
                "en_US": "Color_Reading"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Color_Reading"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "stroop_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "word_concord",
            "displayName": {
                "en_US": "Word_Concord"
            },
            "definition": {
                "en_US": "Word_Concord"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Word_Concord"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "stroop_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "word_discord",
            "displayName": {
                "en_US": "Word_Discord"
            },
            "definition": {
                "en_US": "Word_Discord"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Word_Discord"
            },
            "synonyms": "Rehabilitation Test",
            "order": 4,
            "groupTermId": {
                "name": "stroop_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "word_color",
            "displayName": {
                "en_US": "Word_Color"
            },
            "definition": {
                "en_US": "Word_Color"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Word_Color"
            },
            "synonyms": "Rehabilitation Test",
            "order": 5,
            "groupTermId": {
                "name": "stroop_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "word_reading_error",
            "displayName": {
                "en_US": "Word_Reading"
            },
            "definition": {
                "en_US": "Word_Reading"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Word_Reading"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "stroop_test_error",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "color_reading_error",
            "displayName": {
                "en_US": "Color_Reading"
            },
            "definition": {
                "en_US": "Color_Reading"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Color_Reading"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "stroop_test_error",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "word_concord_error",
            "displayName": {
                "en_US": "Word_Concord"
            },
            "definition": {
                "en_US": "Word_Concord"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Word_Concord"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "stroop_test_error",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "word_discord_error",
            "displayName": {
                "en_US": "Word_Discord"
            },
            "definition": {
                "en_US": "Word_Discord"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Word_Discord"
            },
            "synonyms": "Rehabilitation Test",
            "order": 4,
            "groupTermId": {
                "name": "stroop_test_error",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "word_color_error",
            "displayName": {
                "en_US": "Word_Color"
            },
            "definition": {
                "en_US": "Word_Color"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Word_Color"
            },
            "synonyms": "Rehabilitation Test",
            "order": 5,
            "groupTermId": {
                "name": "stroop_test_error",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "neurologic_impairment_week_4",
            "displayName": {
                "en_US": "neurologic impairment [< 4~6주 ]"
            },
            "definition": {
                "en_US": "neurologic impairment [< 4~6주 ]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "neurologic impairment [< 4~6주 ]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 13,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "none"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "depression"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "anxiety"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "psychosis"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "peripheral palsy"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "dysarthria"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "G.weakness"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "neurologic_impairment_month_6",
            "displayName": {
                "en_US": "neurologic impairment [< 6개월 ]"
            },
            "definition": {
                "en_US": "neurologic impairment [< 6개월 ]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "neurologic impairment [< 6개월 ]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 14,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "none"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "depression"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "anxiety"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "psychosis"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "peripheral palsy"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "dysarthria"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "G.weakness"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "neurologic_impairment_month_12",
            "displayName": {
                "en_US": "neurologic impairment [< 12개월 ]"
            },
            "definition": {
                "en_US": "neurologic impairment [< 12개월 ]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "neurologic impairment [< 12개월 ]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 15,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "none"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "depression"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "anxiety"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "psychosis"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "peripheral palsy"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "dysarthria"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "G.weakness"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "neurologic_ae_bool",
            "displayName": {
                "en_US": "Yes or NO"
            },
            "definition": {
                "en_US": "Yes or NO"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Yes or NO"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "neurologic_ae",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "No"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "neurologic",
            "displayName": {
                "en_US": "neurologic"
            },
            "definition": {
                "en_US": "neurologic"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "neurologic"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "neurologic_ae",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "No"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "cognitive",
            "displayName": {
                "en_US": "cognitive"
            },
            "definition": {
                "en_US": "cognitive"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "cognitive"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "neurologic_ae",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "No"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "psychiatric",
            "displayName": {
                "en_US": "psychiatric"
            },
            "definition": {
                "en_US": "psychiatric"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "psychiatric"
            },
            "synonyms": "Rehabilitation Test",
            "order": 4,
            "groupTermId": {
                "name": "neurologic_ae",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "No"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "neurologic_sign_comment",
            "displayName": {
                "en_US": "neurologic sign & symptoms, etc."
            },
            "definition": {
                "en_US": "neurologic sign & symptoms, etc."
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "neurologic sign & symptoms, etc."
            },
            "synonyms": "Rehabilitation Test",
            "order": 5,
            "groupTermId": {
                "name": "neurologic_ae",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "Date",
            "termName": "reh_opd_reserve_date",
            "displayName": {
                "en_US": "외래 예약 날짜"
            },
            "definition": {
                "en_US": "외래 예약 날짜"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "외래 예약 날짜"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 1,
            "groupTermId": {
                "name": "reh_opd_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3
        },
        {
            "termType": "List",
            "termName": "reh_opd_f_u_bool",
            "displayName": {
                "en_US": "REH OPD F/U"
            },
            "definition": {
                "en_US": "REH OPD F/U"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "REH OPD F/U"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "reh_opd_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "No"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "exposed_gds_week_4",
            "displayName": {
                "en_US": "노출기준 GDS [< 4~6주 ]"
            },
            "definition": {
                "en_US": "노출기준 GDS [< 4~6주 ]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "노출기준 GDS [< 4~6주 ]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "exposed_gds_week_6",
            "displayName": {
                "en_US": "노출기준 GDS [< 6주 ]"
            },
            "definition": {
                "en_US": "노출기준 GDS [< 6주 ]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "노출기준 GDS [< 6주 ]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "exposed_gds_year_1",
            "displayName": {
                "en_US": "노출기준 GDS [1yr]"
            },
            "definition": {
                "en_US": "노출기준 GDS [1yr]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "노출기준 GDS [1yr]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "mrs_week_4",
            "displayName": {
                "en_US": "mRS[< 4~6주 ]"
            },
            "definition": {
                "en_US": "mRS[< 4~6주 ]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "mRS[< 4~6주 ]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 4,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "gos_week_4",
            "displayName": {
                "en_US": "GOS[< 4~6주 ]"
            },
            "definition": {
                "en_US": "GOS[< 4~6주 ]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "GOS[< 4~6주 ]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 5,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "cpc_week_4",
            "displayName": {
                "en_US": "CPC[< 4~6주 ]"
            },
            "definition": {
                "en_US": "CPC[< 4~6주 ]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CPC[< 4~6주 ]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 6,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "mrs_month_6",
            "displayName": {
                "en_US": "mRS [<6개월]"
            },
            "definition": {
                "en_US": "mRS [<6개월]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "mRS [<6개월]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 7,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "gos_month_6",
            "displayName": {
                "en_US": "GOS [<6개월]"
            },
            "definition": {
                "en_US": "GOS [<6개월]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "GOS [<6개월]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 8,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "cpc_month_6",
            "displayName": {
                "en_US": "CPC [<6개월]"
            },
            "definition": {
                "en_US": "CPC [<6개월]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CPC [<6개월]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 9,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "mrs_month_12",
            "displayName": {
                "en_US": "mRS[12개월]"
            },
            "definition": {
                "en_US": "mRS[12개월]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "mRS[12개월]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 10,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "gos_month_12",
            "displayName": {
                "en_US": "GOS[12개월]"
            },
            "definition": {
                "en_US": "GOS[12개월]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "GOS[12개월]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 11,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "cpc_month_12",
            "displayName": {
                "en_US": "CPC[12개월]"
            },
            "definition": {
                "en_US": "CPC[12개월]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CPC[12개월]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 12,
            "groupTermId": {
                "name": "neurologic_tc",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "Group",
            "termName": "in_out_info",
            "displayName": {
                "ko_KR": "입퇴원 정보",
                "en_US": "입퇴원 정보"
            },
            "definition": {
                "ko_KR": "In and Out Information",
                "en_US": "In and Out Information"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "",
                "en_US": ""
            },
            "synonyms": "ER Initial Evaluation",
            "mandatory": true,
            "order": 1,
            "groupTermId": {
                "name": "er_init_eval",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3
        },
        {
            "termType": "List",
            "termName": "way_visit_hp",
            "displayName": {
                "ko_KR": "내원 수단",
                "en_US": "내원 수단"
            },
            "definition": {
                "ko_KR": "내원 수단 고르기",
                "en_US": "내원 수단 고르기"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "내원 수단 선택",
                "en_US": "내원 수단 선택"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 1,
            "groupTermId": {
                "name": "in_out_info",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "119 구급차",
                        "en_US": "119 구급차"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "병원 구급차",
                        "en_US": "병원 구급차"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "기타 구급차",
                        "en_US": "기타 구급차"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "ko_KR": "경찰차",
                        "en_US": "경찰차"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "ko_KR": "항공이송",
                        "en_US": "항공이송"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "ko_KR": "그 외 교통수단",
                        "en_US": "그 외 교통수단"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "ko_KR": "도보",
                        "en_US": "도보"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "ko_KR": "기타",
                        "en_US": "기타"
                    }
                },
                {
                    "value": "8",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "way_visit_hp_str",
            "displayName": {
                "ko_KR": "내원 수단 - 기타",
                "en_US": "내원 수단 - 기타"
            },
            "definition": {
                "ko_KR": "내원 수단 - 기타",
                "en_US": "내원 수단 - 기타"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "기타 내원 수단 서술",
                "en_US": "기타 내원 수단 서술"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 2,
            "groupTermId": {
                "name": "in_out_info",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Group",
            "termName": "vs_hp",
            "displayName": {
                "ko_KR": "내원 당시 활력징후",
                "en_US": "내원 당시 활력징후"
            },
            "definition": {
                "ko_KR": "Vital sign in Hospital",
                "en_US": "Vital sign in Hospital"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "",
                "en_US": ""
            },
            "synonyms": "ER Initial Evaluation",
            "mandatory": true,
            "order": 2,
            "groupTermId": {
                "name": "er_init_eval",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3
        },
        {
            "termType": "Numeric",
            "termName": "sbp",
            "displayName": {
                "ko_KR": "SBP",
                "en_US": "SBP"
            },
            "definition": {
                "ko_KR": "Systolic Blood Pressure",
                "en_US": "Systolic Blood Pressure"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Systolic Blood Pressure",
                "en_US": "Systolic Blood Pressure"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 1,
            "groupTermId": {
                "name": "vs_hp",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "dbp",
            "displayName": {
                "ko_KR": "DBP",
                "en_US": "DBP"
            },
            "definition": {
                "ko_KR": "Diastolic Blood Pressure",
                "en_US": "Diastolic Blood Pressure"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Diastolic Blood Pressure",
                "en_US": "Diastolic Blood Pressure"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 2,
            "groupTermId": {
                "name": "vs_hp",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "pr",
            "displayName": {
                "ko_KR": "PR",
                "en_US": "PR"
            },
            "definition": {
                "ko_KR": "Pulse Rate",
                "en_US": "Pulse Rate"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Pulse Rate",
                "en_US": "Pulse Rate"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 3,
            "groupTermId": {
                "name": "vs_hp",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "rr",
            "displayName": {
                "ko_KR": "RR",
                "en_US": "RR"
            },
            "definition": {
                "ko_KR": "Respiratory Rate",
                "en_US": "Respiratory Rate"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Respiratory Rate",
                "en_US": "Respiratory Rate"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 4,
            "groupTermId": {
                "name": "vs_hp",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Group",
            "termName": "ms_on",
            "displayName": {
                "ko_KR": "발견당시 의식상태",
                "en_US": "발견당시 의식상태"
            },
            "definition": {
                "ko_KR": "Mental sign on detect",
                "en_US": "Mental sign on detect"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "",
                "en_US": ""
            },
            "synonyms": "ER Initial Evaluation",
            "mandatory": true,
            "order": 3,
            "groupTermId": {
                "name": "er_init_eval",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3
        },
        {
            "termType": "List",
            "termName": "avpu",
            "displayName": {
                "ko_KR": "AVPU",
                "en_US": "AVPU"
            },
            "definition": {
                "ko_KR": "Alert/Verbal/Painful/Unresponsive",
                "en_US": "Alert/Verbal/Painful/Unresponsive"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Alert/Verbal/Painful/Unresponsive",
                "en_US": "Alert/Verbal/Painful/Unresponsive"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 1,
            "groupTermId": {
                "name": "ms_on",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "A",
                    "labelMap": {
                        "ko_KR": "Alert",
                        "en_US": "Alert"
                    }
                },
                {
                    "value": "V",
                    "labelMap": {
                        "ko_KR": "Verbal",
                        "en_US": "Verbal"
                    }
                },
                {
                    "value": "P",
                    "labelMap": {
                        "ko_KR": "Painful",
                        "en_US": "Painful"
                    }
                },
                {
                    "value": "U",
                    "labelMap": {
                        "ko_KR": "Unresponsible",
                        "en_US": "Unresponsible"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "conciousness",
            "displayName": {
                "ko_KR": "Conciousness",
                "en_US": "Conciousness"
            },
            "definition": {
                "ko_KR": "Conciousness",
                "en_US": "Conciousness"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Conciousness",
                "en_US": "Conciousness"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 2,
            "groupTermId": {
                "name": "ms_on",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "A",
                    "labelMap": {
                        "ko_KR": "Alert",
                        "en_US": "Alert"
                    }
                },
                {
                    "value": "D",
                    "labelMap": {
                        "ko_KR": "Drowsy",
                        "en_US": "Drowsy"
                    }
                },
                {
                    "value": "DD",
                    "labelMap": {
                        "ko_KR": "Deep Drowsy",
                        "en_US": "Deep Drowsy"
                    }
                },
                {
                    "value": "S",
                    "labelMap": {
                        "ko_KR": "Stupor",
                        "en_US": "Stupor"
                    }
                },
                {
                    "value": "SC",
                    "labelMap": {
                        "ko_KR": "Semicoma",
                        "en_US": "Semicoma"
                    }
                },
                {
                    "value": "C",
                    "labelMap": {
                        "ko_KR": "Coma",
                        "en_US": "Coma"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "gcs",
            "displayName": {
                "ko_KR": "GCS",
                "en_US": "GCS"
            },
            "definition": {
                "ko_KR": "Glasgow Coma Scale",
                "en_US": "Glasgow Coma Scale"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "GCS(자동 계산)",
                "en_US": "GCS(자동 계산)"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 3,
            "groupTermId": {
                "name": "ms_on",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "String",
            "termName": "ms_comment",
            "displayName": {
                "ko_KR": "comment",
                "en_US": "comment"
            },
            "definition": {
                "ko_KR": "mental sign comment",
                "en_US": "mental sign comment"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "초기의식변화 등 서술",
                "en_US": "초기의식변화 등 서술"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 4,
            "groupTermId": {
                "name": "ms_on",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "Group",
            "termName": "intubation",
            "displayName": {
                "ko_KR": "기관 삽관",
                "en_US": "기관 삽관"
            },
            "definition": {
                "ko_KR": "In,Extubation",
                "en_US": "In,Extubation"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "",
                "en_US": ""
            },
            "synonyms": "ER Initial Evaluation",
            "mandatory": true,
            "order": 4,
            "groupTermId": {
                "name": "er_init_eval",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3
        },
        {
            "termType": "List",
            "termName": "intubate",
            "displayName": {
                "ko_KR": "Intubation",
                "en_US": "Intubation"
            },
            "definition": {
                "ko_KR": "Intubation",
                "en_US": "Intubation"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Intubation",
                "en_US": "Intubation"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 1,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "No",
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "Initial",
                        "en_US": "Initial"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "in ER",
                        "en_US": "in ER"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "extubate",
            "displayName": {
                "ko_KR": "Extubation",
                "en_US": "Extubation"
            },
            "definition": {
                "ko_KR": "Extubation",
                "en_US": "Extubation"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Extubation",
                "en_US": "Extubation"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 2,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "No",
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "Yes",
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "tra",
                        "en_US": "tra"
                    }
                }
            ]
        },
        {
            "termType": "Date",
            "termName": "alert_time",
            "displayName": {
                "ko_KR": "Last alert time / exposure onset time",
                "en_US": "Last alert time / exposure onset time"
            },
            "definition": {
                "ko_KR": "Last alert time / exposure onset time",
                "en_US": "Last alert time / exposure onset time"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Last alert time / exposure onset time",
                "en_US": "Last alert time / exposure onset time"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 3,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "enableTime": true
        },
        {
            "termType": "Date",
            "termName": "detect_time",
            "displayName": {
                "ko_KR": "발견시간",
                "en_US": "발견시간"
            },
            "definition": {
                "ko_KR": "Detect time",
                "en_US": "Detect time"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Detect time",
                "en_US": "Detect time"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 4,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "enableTime": true
        },
        {
            "termType": "Date",
            "termName": "first_hp_arrived",
            "displayName": {
                "ko_KR": "1차 병원 도착 시간",
                "en_US": "1차 병원 도착 시간"
            },
            "definition": {
                "ko_KR": "1st Hospital arrived Time",
                "en_US": "1st Hospital arrived Time"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "1st Hospital arrived Time",
                "en_US": "1st Hospital arrived Time"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 5,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "enableTime": true
        },
        {
            "termType": "Date",
            "termName": "hp_arrived",
            "displayName": {
                "ko_KR": "본원 도착 시간",
                "en_US": "본원 도착 시간"
            },
            "definition": {
                "ko_KR": "Hospital arrived Time",
                "en_US": "Hospital arrived Time"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Hospital arrived Time",
                "en_US": "Hospital arrived Time"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 6,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "enableTime": true
        },
        {
            "termType": "List",
            "termName": "acute_classific",
            "displayName": {
                "ko_KR": "Acute classification",
                "en_US": "Acute classification"
            },
            "definition": {
                "ko_KR": "Acute classification",
                "en_US": "Acute classification"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Acute classification",
                "en_US": "Acute classification"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 7,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "non-acute(본원까지 소요시간 24시간 이상)",
                        "en_US": "non-acute(본원까지 소요시간 24시간 이상)"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "acute",
                        "en_US": "acute"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "DNS",
                        "en_US": "DNS"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "non_acute_comment",
            "displayName": {
                "ko_KR": "non-acute_comment",
                "en_US": "non-acute_comment"
            },
            "definition": {
                "ko_KR": "non-acute_comment",
                "en_US": "non-acute_comment"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "non-acute_comment",
                "en_US": "non-acute_comment"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 8,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "Numeric",
            "termName": "co_exposure_time",
            "displayName": {
                "ko_KR": "최대 CO 노출 시간",
                "en_US": "최대 CO 노출 시간"
            },
            "definition": {
                "ko_KR": "Max CO exposure time",
                "en_US": "Max CO exposure time"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Max CO exposure time",
                "en_US": "Max CO exposure time"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 9,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "unit": "hr",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "to_hp_time",
            "displayName": {
                "ko_KR": "본원까지 소요시간",
                "en_US": "본원까지 소요시간"
            },
            "definition": {
                "ko_KR": "To Hospital Time",
                "en_US": "To Hospital Time"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "To Hospital Time",
                "en_US": "To Hospital Time"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 10,
            "groupTermId": {
                "name": "intubation",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "unit": "hr",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Group",
            "termName": "phx",
            "displayName": {
                "ko_KR": "PHx",
                "en_US": "PHx"
            },
            "definition": {
                "ko_KR": "PHx",
                "en_US": "PHx"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "",
                "en_US": ""
            },
            "synonyms": "ER Initial Evaluation",
            "mandatory": true,
            "order": 5,
            "groupTermId": {
                "name": "er_init_eval",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3
        },
        {
            "termType": "List",
            "termName": "smoke",
            "displayName": {
                "ko_KR": "흡연력",
                "en_US": "흡연력"
            },
            "definition": {
                "ko_KR": "Smoking",
                "en_US": "Smoking"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Smoking",
                "en_US": "Smoking"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 1,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "No",
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "Current",
                        "en_US": "Current"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "Former",
                        "en_US": "Former"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "alcohol",
            "displayName": {
                "ko_KR": "음주력",
                "en_US": "음주력"
            },
            "definition": {
                "ko_KR": "Drinking(alcohol)",
                "en_US": "Drinking(alcohol)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Drinking(alcohol)",
                "en_US": "Drinking(alcohol)"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 2,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "No",
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "Yes",
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "htn",
            "displayName": {
                "ko_KR": "HTN",
                "en_US": "HTN"
            },
            "definition": {
                "ko_KR": "HTN",
                "en_US": "HTN"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "HTN",
                "en_US": "HTN"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 3,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "dm",
            "displayName": {
                "ko_KR": "DM",
                "en_US": "DM"
            },
            "definition": {
                "ko_KR": "DM",
                "en_US": "DM"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "DM",
                "en_US": "DM"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 4,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "hld",
            "displayName": {
                "ko_KR": "HLD",
                "en_US": "HLD"
            },
            "definition": {
                "ko_KR": "HLD",
                "en_US": "HLD"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "HLD",
                "en_US": "HLD"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 5,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "lung_disease",
            "displayName": {
                "ko_KR": "Lung disease",
                "en_US": "Lung disease"
            },
            "definition": {
                "ko_KR": "Lung disease",
                "en_US": "Lung disease"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Lung disease",
                "en_US": "Lung disease"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 6,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "lung_disease_comment",
            "displayName": {
                "ko_KR": "Lung disease comment",
                "en_US": "Lung disease comment"
            },
            "definition": {
                "ko_KR": "Lung disease comment",
                "en_US": "Lung disease comment"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Lung disease comment",
                "en_US": "Lung disease comment"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 7,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "ihd",
            "displayName": {
                "ko_KR": "IHD",
                "en_US": "IHD"
            },
            "definition": {
                "ko_KR": "IHD",
                "en_US": "IHD"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "IHD",
                "en_US": "IHD"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 8,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "heart_disease",
            "displayName": {
                "ko_KR": "Heart disease",
                "en_US": "Heart disease"
            },
            "definition": {
                "ko_KR": "Heart disease",
                "en_US": "Heart disease"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Heart disease",
                "en_US": "Heart disease"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 9,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "heart_disease_comment",
            "displayName": {
                "ko_KR": "Heart disease comment",
                "en_US": "Heart disease comment"
            },
            "definition": {
                "ko_KR": "Heart disease comment",
                "en_US": "Heart disease comment"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Heart disease comment",
                "en_US": "Heart disease comment"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 11,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "liver_disease",
            "displayName": {
                "ko_KR": "Liver disease",
                "en_US": "Liver disease"
            },
            "definition": {
                "ko_KR": "Liver disease",
                "en_US": "Liver disease"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Liver disease",
                "en_US": "Liver disease"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 12,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "liver_disease_comment",
            "displayName": {
                "ko_KR": "Liver disease comment",
                "en_US": "Liver disease comment"
            },
            "definition": {
                "ko_KR": "Liver disease comment",
                "en_US": "Liver disease comment"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Liver disease comment",
                "en_US": "Liver disease comment"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 13,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "kidney_disease",
            "displayName": {
                "ko_KR": "Kidney disease",
                "en_US": "Kidney disease"
            },
            "definition": {
                "ko_KR": "Kidney disease",
                "en_US": "Kidney disease"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Kidney disease",
                "en_US": "Kidney disease"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 14,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "kidney_disease_comment",
            "displayName": {
                "ko_KR": "Kidney disease comment",
                "en_US": "Kidney disease comment"
            },
            "definition": {
                "ko_KR": "Kidney disease comment",
                "en_US": "Kidney disease comment"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Kidney disease comment",
                "en_US": "Kidney disease comment"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 15,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "stroke",
            "displayName": {
                "ko_KR": "Stroke",
                "en_US": "Stroke"
            },
            "definition": {
                "ko_KR": "Stroke",
                "en_US": "Stroke"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Stroke",
                "en_US": "Stroke"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 16,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "cancer",
            "displayName": {
                "ko_KR": "Cancer",
                "en_US": "Cancer"
            },
            "definition": {
                "ko_KR": "Cancer",
                "en_US": "Cancer"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Cancer",
                "en_US": "Cancer"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 17,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "psycology",
            "displayName": {
                "ko_KR": "Psychology(spr, depressive, suicide attempt, etc.)",
                "en_US": "Psychology(spr, depressive, suicide attempt, etc.)"
            },
            "definition": {
                "ko_KR": "Psychology(spr, depressive, suicide attempt, etc.)",
                "en_US": "Psychology(spr, depressive, suicide attempt, etc.)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Psychology(spr, depressive, suicide attempt, etc.)",
                "en_US": "Psychology(spr, depressive, suicide attempt, etc.)"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 18,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "brain_damage",
            "displayName": {
                "ko_KR": "뇌손상/뇌병변/간질/지체장애/치매 등",
                "en_US": "뇌손상/뇌병변/간질/지체장애/치매 등"
            },
            "definition": {
                "ko_KR": "뇌손상/뇌병변/간질/지체장애/치매 등",
                "en_US": "뇌손상/뇌병변/간질/지체장애/치매 등"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "뇌손상/뇌병변/간질/지체장애/치매 등",
                "en_US": "뇌손상/뇌병변/간질/지체장애/치매 등"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 19,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "co_intoxic",
            "displayName": {
                "ko_KR": "CO intoxication",
                "en_US": "CO intoxication"
            },
            "definition": {
                "ko_KR": "CO intoxication",
                "en_US": "CO intoxication"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "CO intoxication",
                "en_US": "CO intoxication"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 20,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "past_disease",
            "displayName": {
                "ko_KR": "기타 과거력",
                "en_US": "기타 과거력"
            },
            "definition": {
                "ko_KR": "기타 과거력",
                "en_US": "기타 과거력"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "기타 과거력",
                "en_US": "기타 과거력"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 21,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "Group",
            "termName": "init_ros",
            "displayName": {
                "ko_KR": "Initial ROS",
                "en_US": "Initial ROS"
            },
            "definition": {
                "ko_KR": "Initial ROS",
                "en_US": "Initial ROS"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "",
                "en_US": ""
            },
            "synonyms": "ER Initial Evaluation",
            "mandatory": true,
            "order": 6,
            "groupTermId": {
                "name": "er_init_eval",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3
        },
        {
            "termType": "List",
            "termName": "loc",
            "displayName": {
                "ko_KR": "LOC",
                "en_US": "LOC"
            },
            "definition": {
                "ko_KR": "LOC",
                "en_US": "LOC"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "LOC",
                "en_US": "LOC"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 1,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "headache",
            "displayName": {
                "ko_KR": "Headache",
                "en_US": "Headache"
            },
            "definition": {
                "ko_KR": "Headache",
                "en_US": "Headache"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Headache",
                "en_US": "Headache"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 2,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "dizziness",
            "displayName": {
                "ko_KR": "Dizziness",
                "en_US": "Dizziness"
            },
            "definition": {
                "ko_KR": "Dizziness",
                "en_US": "Dizziness"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Dizziness",
                "en_US": "Dizziness"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 3,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "nausea",
            "displayName": {
                "ko_KR": "nausea",
                "en_US": "nausea"
            },
            "definition": {
                "ko_KR": "nausea",
                "en_US": "nausea"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "nausea",
                "en_US": "nausea"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 4,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "vomiting",
            "displayName": {
                "ko_KR": "Vomiting",
                "en_US": "Vomiting"
            },
            "definition": {
                "ko_KR": "Vomiting",
                "en_US": "Vomiting"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Vomiting",
                "en_US": "Vomiting"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 5,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "dyspnea",
            "displayName": {
                "ko_KR": "Dyspnea",
                "en_US": "Dyspnea"
            },
            "definition": {
                "ko_KR": "Dyspnea",
                "en_US": "Dyspnea"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Dyspnea",
                "en_US": "Dyspnea"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 6,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "chest_discomfort",
            "displayName": {
                "ko_KR": "Chest discomfort/pain",
                "en_US": "Chest discomfort/pain"
            },
            "definition": {
                "ko_KR": "Chest discomfort/pain",
                "en_US": "Chest discomfort/pain"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Chest discomfort/pain",
                "en_US": "Chest discomfort/pain"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 7,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "g_weakness",
            "displayName": {
                "ko_KR": "G.weakness",
                "en_US": "G.weakness"
            },
            "definition": {
                "ko_KR": "G.weakness",
                "en_US": "G.weakness"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "G.weakness",
                "en_US": "G.weakness"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 8,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "아니오",
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "other_symptoms",
            "displayName": {
                "ko_KR": "기타 증상",
                "en_US": "기타 증상"
            },
            "definition": {
                "ko_KR": "기타 증상",
                "en_US": "기타 증상"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "기타 증상",
                "en_US": "기타 증상"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 10,
            "groupTermId": {
                "name": "phx",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "nex_abnormal",
            "displayName": {
                "ko_KR": "NEx 이상 여부",
                "en_US": "NEx 이상 여부"
            },
            "definition": {
                "ko_KR": "NEx 이상 여부",
                "en_US": "NEx 이상 여부"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "NEx 이상 여부",
                "en_US": "NEx 이상 여부"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 9,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "mental_change",
            "displayName": {
                "ko_KR": "Mental Change",
                "en_US": "Mental Change"
            },
            "definition": {
                "ko_KR": "Mental Change",
                "en_US": "Mental Change"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Mental Change",
                "en_US": "Mental Change"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 10,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "motor_sx",
            "displayName": {
                "ko_KR": "Motor Sx",
                "en_US": "Motor Sx"
            },
            "definition": {
                "ko_KR": "Motor Sx",
                "en_US": "Motor Sx"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Motor Sx",
                "en_US": "Motor Sx"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 11,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "sensory_sx",
            "displayName": {
                "ko_KR": "Sensory Sx",
                "en_US": "Sensory Sx"
            },
            "definition": {
                "ko_KR": "Sensory Sx",
                "en_US": "Sensory Sx"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Sensory Sx",
                "en_US": "Sensory Sx"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 12,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "dysarthria",
            "displayName": {
                "ko_KR": "Dysarthria",
                "en_US": "Dysarthria"
            },
            "definition": {
                "ko_KR": "Dysarthria",
                "en_US": "Dysarthria"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Dysarthria",
                "en_US": "Dysarthria"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 13,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "vision_sx",
            "displayName": {
                "ko_KR": "Vision Sx",
                "en_US": "Vision Sx"
            },
            "definition": {
                "ko_KR": "Vision Sx",
                "en_US": "Vision Sx"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Vision Sx",
                "en_US": "Vision Sx"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 14,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "cognitive_dysfunction",
            "displayName": {
                "ko_KR": "Cognitive dysfunction",
                "en_US": "Cognitive dysfunction"
            },
            "definition": {
                "ko_KR": "Cognitive dysfunction",
                "en_US": "Cognitive dysfunction"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Cognitive dysfunction",
                "en_US": "Cognitive dysfunction"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 15,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "미상",
                        "en_US": "미상"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "예",
                        "en_US": "예"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "etc_nex",
            "displayName": {
                "ko_KR": "ETC NEx",
                "en_US": "ETC NEx"
            },
            "definition": {
                "ko_KR": "ETC NEx",
                "en_US": "ETC NEx"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "ETC NEx",
                "en_US": "ETC NEx"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 16,
            "groupTermId": {
                "name": "init_ros",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "Numeric",
            "termName": "co_retest",
            "displayName": {
                "ko_KR": "CO 재시도_본원진료기준",
                "en_US": "CO 재시도_본원진료기준"
            },
            "definition": {
                "ko_KR": "CO 재시도_본원진료기준",
                "en_US": "CO 재시도_본원진료기준"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "CO 재시도_본원진료기준",
                "en_US": "CO 재시도_본원진료기준"
            },
            "synonyms": "CO profile",
            "order": 1,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "intentional",
            "displayName": {
                "ko_KR": "의도성",
                "en_US": "의도성"
            },
            "definition": {
                "ko_KR": "의도성",
                "en_US": "의도성"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "의도성",
                "en_US": "의도성"
            },
            "synonyms": "CO profile",
            "order": 2,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "Accidental",
                        "en_US": "Accidental"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "Intentional",
                        "en_US": "Intentional"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "Unclear",
                        "en_US": "Unclear"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "co_source",
            "displayName": {
                "ko_KR": "Source",
                "en_US": "Source"
            },
            "definition": {
                "ko_KR": "Source",
                "en_US": "Source"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Source",
                "en_US": "Source"
            },
            "synonyms": "CO profile",
            "order": 3,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "charcoal(석탄, 숯)",
                        "en_US": "charcoal(석탄, 숯)"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "firewood(장작)",
                        "en_US": "firewood(장작)"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "ko_KR": "gas(기체, 액체연료, 매연)",
                        "en_US": "gas(기체, 액체연료, 매연)"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "ko_KR": "fire",
                        "en_US": "fire"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "ko_KR": "기타",
                        "en_US": "기타"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "gas_classific",
            "displayName": {
                "ko_KR": "GAS classification",
                "en_US": "GAS classification"
            },
            "definition": {
                "ko_KR": "GAS classification",
                "en_US": "GAS classification"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "GAS classification",
                "en_US": "GAS classification"
            },
            "synonyms": "CO profile",
            "order": 4,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "기체 탄화수소 연료(LNG, LPG, butane gas)",
                        "en_US": "기체 탄화수소 연료(LNG, LPG, butane gas)"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "액체 탄화수소 연료(기름, 석유, 등유, 고체, 매연 포함)",
                        "en_US": "액체 탄화수소 연료(기름, 석유, 등유, 고체, 매연 포함)"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "ko_KR": "미분류",
                        "en_US": "미분류"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "ko_KR": "no EMR data",
                        "en_US": "no EMR data"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "co_drug",
            "displayName": {
                "ko_KR": "DRUG",
                "en_US": "DRUG"
            },
            "definition": {
                "ko_KR": "DRUG",
                "en_US": "DRUG"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "DRUG",
                "en_US": "DRUG"
            },
            "synonyms": "CO profile",
            "order": 5,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "No",
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "Yes",
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "co_nfs",
            "displayName": {
                "ko_KR": "국과수",
                "en_US": "국과수"
            },
            "definition": {
                "ko_KR": "국과수",
                "en_US": "국과수"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "국과수",
                "en_US": "국과수"
            },
            "synonyms": "CO profile",
            "order": 6,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            },
            "maxLength": 1024,
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "alcohol_co_ingestion",
            "displayName": {
                "ko_KR": "Alcohol co-ingestion",
                "en_US": "Alcohol co-ingestion"
            },
            "definition": {
                "ko_KR": "Alcohol co-ingestion",
                "en_US": "Alcohol co-ingestion"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "Alcohol co-ingestion",
                "en_US": "Alcohol co-ingestion"
            },
            "synonyms": "CO profile",
            "order": 7,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "ko_KR": "미시행",
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "ko_KR": "No",
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "ko_KR": "Drunken",
                        "en_US": "Drunken"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "ko_KR": "Serum Alcohol",
                        "en_US": "Serum Alcohol"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "s_ethanol",
            "displayName": {
                "ko_KR": "S_Ethanol",
                "en_US": "S_Ethanol"
            },
            "definition": {
                "ko_KR": "S_Ethanol",
                "en_US": "S_Ethanol"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "S_Ethanol",
                "en_US": "S_Ethanol"
            },
            "synonyms": "CO profile",
            "order": 8,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "unit": "mg/dl",
            "placeHolder": {
                "ko_KR": "미시행",
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "cogas_score",
            "displayName": {
                "ko_KR": "COGAS scoring",
                "en_US": "COGAS scoring"
            },
            "definition": {
                "ko_KR": "COGAS scoring",
                "en_US": "COGAS scoring"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "ko_KR": "1=age 초과 50 1=GCS 이하 12 1=shock 1=no HBOT 1=CK 초과 320",
                "en_US": "1=age 초과 50 1=GCS 이하 12 1=shock 1=no HBOT 1=CK 초과 320"
            },
            "synonyms": "CO profile",
            "order": 9,
            "groupTermId": {
                "name": "co_profile",
                "version": "1.0.0"
            },
            "status": 2,
            "state": 3,
            "placeHolder": {
                "ko_KR": "?",
                "en_US": "?"
            }
        },
        {
            "termType": "Group",
            "termName": "out_result",
            "displayName": {
                "en_US": "퇴실 결과 및 사유"
            },
            "definition": {
                "en_US": "Out Result"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "In and Out Result",
            "order": 1,
            "groupTermId": {
                "name": "in_out_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "way_back",
            "displayName": {
                "en_US": "귀가"
            },
            "definition": {
                "en_US": "귀가"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "귀가"
            },
            "synonyms": "In and Out Result",
            "order": 1,
            "groupTermId": {
                "name": "out_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "증상이 호전되어 귀가"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "가망없는 퇴원"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "자의 퇴원"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "기타 다른 상태로 귀가(경찰연행, 탈원 포함)"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "move_hp",
            "displayName": {
                "en_US": "전원"
            },
            "definition": {
                "en_US": "전원"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "전원"
            },
            "synonyms": "In and Out Result",
            "order": 2,
            "groupTermId": {
                "name": "out_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "장기시설로 전원(장기요양의료기관)"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "환자사정으로 전원"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "기타 다른 사유로 전원"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "in_hp",
            "displayName": {
                "en_US": "입원"
            },
            "definition": {
                "en_US": "입원"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "입원"
            },
            "synonyms": "In and Out Result",
            "order": 3,
            "groupTermId": {
                "name": "out_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "일반병실로 입원"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "중환자실로 입원"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "passing",
            "displayName": {
                "en_US": "사망"
            },
            "definition": {
                "en_US": "사망"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "사망"
            },
            "synonyms": "In and Out Result",
            "order": 4,
            "groupTermId": {
                "name": "out_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "D.O.A"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "응급실에서 DNR로 사망"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "응급실에서 CPR후 사망"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "기타 다른 사유로 사망(병원에서 자살 포함)"
                    }
                }
            ]
        },
        {
            "termType": "Group",
            "termName": "icu_result",
            "displayName": {
                "en_US": "입퇴원 결과 및 사유"
            },
            "definition": {
                "en_US": "입퇴원 결과 및 사유"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "입퇴원 결과 및 사유"
            },
            "synonyms": "In and Out Result",
            "order": 2,
            "groupTermId": {
                "name": "in_out_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "out_hp_reason",
            "displayName": {
                "en_US": "퇴원 사유"
            },
            "definition": {
                "en_US": "퇴원 사유"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 사유"
            },
            "synonyms": "In and Out Result",
            "order": 1,
            "groupTermId": {
                "name": "icu_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "정상 퇴원"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "자의 퇴원"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "전원"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "사망"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "탈원"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "기타(서술)"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "미상"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "out_hp_reason_str",
            "displayName": {
                "en_US": "퇴원 사유 - 기타"
            },
            "definition": {
                "en_US": "퇴원 사유 - 기타"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 사유 - 기타"
            },
            "synonyms": "In and Out Result",
            "order": 2,
            "groupTermId": {
                "name": "icu_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "icu_to_gw",
            "displayName": {
                "en_US": "ICU>GW"
            },
            "definition": {
                "en_US": "ICU>GW"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ICU>GW"
            },
            "synonyms": "In and Out Result",
            "order": 3,
            "groupTermId": {
                "name": "icu_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "NA"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "ICU stay"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "icu_stay",
            "displayName": {
                "en_US": "ICU stay"
            },
            "definition": {
                "en_US": "ICU stay"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ICU stay"
            },
            "synonyms": "In and Out Result",
            "order": 4,
            "groupTermId": {
                "name": "icu_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Date",
            "termName": "out_hp_date",
            "displayName": {
                "en_US": "퇴원일"
            },
            "definition": {
                "en_US": "퇴원일"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원일"
            },
            "synonyms": "In and Out Result",
            "order": 5,
            "groupTermId": {
                "name": "icu_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "enableTime": true
        },
        {
            "termType": "Numeric",
            "termName": "total_hp_date",
            "displayName": {
                "en_US": "총 입원일수"
            },
            "definition": {
                "en_US": "총 입원일수"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "총 입원일수"
            },
            "synonyms": "In and Out Result",
            "order": 6,
            "groupTermId": {
                "name": "icu_result",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "shock",
            "displayName": {
                "en_US": "shock"
            },
            "definition": {
                "en_US": "shock"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "shock"
            },
            "synonyms": "Abnormal Reaction",
            "order": 1,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "arteriopressor",
            "displayName": {
                "en_US": "승압제"
            },
            "definition": {
                "en_US": "승압제"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "승압제"
            },
            "synonyms": "Abnormal Reaction",
            "order": 2,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "NE(norepinephrine)"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "VP(vasopressin)"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "DB(dobutamine)"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "burn",
            "displayName": {
                "en_US": "Burn"
            },
            "definition": {
                "en_US": "Burn"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Burn"
            },
            "synonyms": "Abnormal Reaction",
            "order": 3,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "steroid_admin",
            "displayName": {
                "en_US": "Steroids administration"
            },
            "definition": {
                "en_US": "Steroids administration"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Steroids administration"
            },
            "synonyms": "Abnormal Reaction",
            "order": 4,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "no use"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "mental change"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "inhalation burn"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "hepatic_inj",
            "displayName": {
                "en_US": "Hepatic injury"
            },
            "definition": {
                "en_US": "Hepatic injury"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Hepatic injury"
            },
            "synonyms": "Abnormal Reaction",
            "order": 5,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "alt_alp_0",
            "displayName": {
                "en_US": "ALT/ALP#0"
            },
            "definition": {
                "en_US": "ALT/ALP#0"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALT/ALP#0"
            },
            "synonyms": "Abnormal Reaction",
            "order": 6,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "alt_alp_1",
            "displayName": {
                "en_US": "ALT/ALP#1"
            },
            "definition": {
                "en_US": "ALT/ALP#1"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALT/ALP#1"
            },
            "synonyms": "Abnormal Reaction",
            "order": 7,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "alt_alp_2",
            "displayName": {
                "en_US": "ALT/ALP#2"
            },
            "definition": {
                "en_US": "ALT/ALP#2"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ALT/ALP#2"
            },
            "synonyms": "Abnormal Reaction",
            "order": 8,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "seizure",
            "displayName": {
                "en_US": "Seizure"
            },
            "definition": {
                "en_US": "Seizure"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Seizure"
            },
            "synonyms": "Abnormal Reaction",
            "order": 9,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "sore",
            "displayName": {
                "en_US": "Sore"
            },
            "definition": {
                "en_US": "Sore"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Sore"
            },
            "synonyms": "Abnormal Reaction",
            "order": 10,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "aki",
            "displayName": {
                "en_US": "AKI"
            },
            "definition": {
                "en_US": "AKI"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "AKI"
            },
            "synonyms": "Abnormal Reaction",
            "order": 11,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "rhabdomyolysis",
            "displayName": {
                "en_US": "Rhabdomyolysis"
            },
            "definition": {
                "en_US": "Rhabdomyolysis"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Rhabdomyolysis"
            },
            "synonyms": "Abnormal Reaction",
            "order": 12,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "pancreatitis",
            "displayName": {
                "en_US": "Pancreatitis"
            },
            "definition": {
                "en_US": "Pancreatitis"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Pancreatitis"
            },
            "synonyms": "Abnormal Reaction",
            "order": 13,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "c_intarction",
            "displayName": {
                "en_US": "C. infarction"
            },
            "definition": {
                "en_US": "C. infarction"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "C. infarction"
            },
            "synonyms": "Abnormal Reaction",
            "order": 14,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "pte",
            "displayName": {
                "en_US": "PTE"
            },
            "definition": {
                "en_US": "PTE"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "PTE"
            },
            "synonyms": "Abnormal Reaction",
            "order": 15,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "muscle_ischemia",
            "displayName": {
                "en_US": "Muscle ischemia/abscess"
            },
            "definition": {
                "en_US": "Muscle ischemia/abscess"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Muscle ischemia/abscess"
            },
            "synonyms": "Abnormal Reaction",
            "order": 16,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "pneumonia",
            "displayName": {
                "en_US": "Pneumonia"
            },
            "definition": {
                "en_US": "Pneumonia"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Pneumonia"
            },
            "synonyms": "Abnormal Reaction",
            "order": 17,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "ear_problem",
            "displayName": {
                "en_US": "EAR problems"
            },
            "definition": {
                "en_US": "EAR problems"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "EAR problems"
            },
            "synonyms": "Abnormal Reaction",
            "order": 18,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "tnl_increased",
            "displayName": {
                "en_US": "TnI increased"
            },
            "definition": {
                "en_US": "TnI increased"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TnI increased"
            },
            "synonyms": "Abnormal Reaction",
            "order": 19,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "complications_etc",
            "displayName": {
                "en_US": "기타합병증"
            },
            "definition": {
                "en_US": "기타합병증"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "기타합병증"
            },
            "synonyms": "Abnormal Reaction",
            "order": 20,
            "groupTermId": {
                "name": "abnormal_react",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "Group",
            "termName": "hbot",
            "displayName": {
                "en_US": "고압산소치료"
            },
            "definition": {
                "en_US": "HBOT"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "HBOT"
            },
            "synonyms": "Clinic",
            "order": 1,
            "groupTermId": {
                "name": "clinic",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "hbot_trial",
            "displayName": {
                "en_US": "HBOT 시행"
            },
            "definition": {
                "en_US": "HBOT 시행"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "HBOT 시행"
            },
            "synonyms": "Clinic",
            "order": 1,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "아니오"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "예"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "protocol_1st",
            "displayName": {
                "en_US": "Protocol 1st"
            },
            "definition": {
                "en_US": "Protocol 1st"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Protocol 1st"
            },
            "synonyms": "Clinic",
            "order": 2,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1st_1",
                    "labelMap": {
                        "en_US": "1"
                    }
                },
                {
                    "value": "1st_2",
                    "labelMap": {
                        "en_US": "2"
                    }
                },
                {
                    "value": "1st_3",
                    "labelMap": {
                        "en_US": "3"
                    }
                },
                {
                    "value": "1st_4",
                    "labelMap": {
                        "en_US": "4"
                    }
                },
                {
                    "value": "1st_5",
                    "labelMap": {
                        "en_US": "5"
                    }
                },
                {
                    "value": "1st_1A",
                    "labelMap": {
                        "en_US": "1A"
                    }
                },
                {
                    "value": "1st_5A",
                    "labelMap": {
                        "en_US": "5A"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "protocol_2nd",
            "displayName": {
                "en_US": "Protocol 2nd"
            },
            "definition": {
                "en_US": "Protocol 2nd"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Protocol 2nd"
            },
            "synonyms": "Clinic",
            "order": 3,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "2nd_1",
                    "labelMap": {
                        "en_US": "1"
                    }
                },
                {
                    "value": "2nd_2",
                    "labelMap": {
                        "en_US": "2"
                    }
                },
                {
                    "value": "2nd_5",
                    "labelMap": {
                        "en_US": "5"
                    }
                },
                {
                    "value": "2nd_1A",
                    "labelMap": {
                        "en_US": "1A"
                    }
                },
                {
                    "value": "2nd_2A",
                    "labelMap": {
                        "en_US": "2A"
                    }
                },
                {
                    "value": "2nd_5A",
                    "labelMap": {
                        "en_US": "5A"
                    }
                }
            ]
        },
        {
            "termType": "Date",
            "termName": "first_hbot_time",
            "displayName": {
                "en_US": "첫 HBOT 시작 시간"
            },
            "definition": {
                "en_US": "첫 HBOT 시작 시간"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "첫 HBOT 시작 시간"
            },
            "synonyms": "Clinic",
            "order": 4,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "enableTime": true
        },
        {
            "termType": "Date",
            "termName": "second_hbot_time",
            "displayName": {
                "en_US": "두번째 HBOT 시작 시간"
            },
            "definition": {
                "en_US": "두번째 HBOT 시작 시간"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "두번째 HBOT 시작 시간"
            },
            "synonyms": "Clinic",
            "order": 5,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "enableTime": true
        },
        {
            "termType": "Numeric",
            "termName": "detect_to_1st_hbot",
            "displayName": {
                "en_US": "발견 to 1st HBOT"
            },
            "definition": {
                "en_US": "발견 to 1st HBOT"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "발견 to 1st HBOT"
            },
            "synonyms": "Clinic",
            "order": 6,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "unit": "hr",
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "arrive_to_1st_hbot",
            "displayName": {
                "en_US": "도착 to 1st HBOT "
            },
            "definition": {
                "en_US": "도착 to 1st HBOT "
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "도착 to 1st HBOT "
            },
            "synonyms": "Clinic",
            "order": 7,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "unit": "hr",
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "arrive_to_2nd_hbot",
            "displayName": {
                "en_US": "도착 to 2nd HBOT "
            },
            "definition": {
                "en_US": "도착 to 2nd HBOT "
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "도착 to 2nd HBOT "
            },
            "synonyms": "Clinic",
            "order": 8,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "unit": "hr",
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "hbot_1st_filled",
            "displayName": {
                "en_US": "첫 HBOT filled 여부"
            },
            "definition": {
                "en_US": "첫 HBOT filled 여부"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "첫 HBOT filled 여부"
            },
            "synonyms": "Clinic",
            "order": 9,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "예"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "아니오"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "hbot_in_24hr",
            "displayName": {
                "en_US": "HBOT < 24hr"
            },
            "definition": {
                "en_US": "HBOT < 24hr"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "HBOT < 24hr"
            },
            "synonyms": "Clinic",
            "order": 10,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "hp_hbot_num",
            "displayName": {
                "en_US": "입원 중 HBOT"
            },
            "definition": {
                "en_US": "입원 중 HBOT"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "입원 중 HBOT"
            },
            "synonyms": "Clinic",
            "order": 11,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "String",
            "termName": "hbot_comment",
            "displayName": {
                "en_US": "comment"
            },
            "definition": {
                "en_US": "comment"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "comment"
            },
            "synonyms": "Clinic",
            "order": 12,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "Numeric",
            "termName": "out_hbot_num",
            "displayName": {
                "en_US": "퇴원 후 HBOT"
            },
            "definition": {
                "en_US": "퇴원 후 HBOT"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 후 HBOT"
            },
            "synonyms": "Clinic",
            "order": 13,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "total_hbot",
            "displayName": {
                "en_US": "총 HBOT"
            },
            "definition": {
                "en_US": "총 HBOT"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "총 HBOT"
            },
            "synonyms": "Clinic",
            "order": 14,
            "groupTermId": {
                "name": "hbot",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Group",
            "termName": "ttm",
            "displayName": {
                "en_US": "TTM"
            },
            "definition": {
                "en_US": "TTM"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TTM"
            },
            "synonyms": "Clinic",
            "order": 2,
            "groupTermId": {
                "name": "clinic",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "ttm_trial",
            "displayName": {
                "en_US": "TTM 시행"
            },
            "definition": {
                "en_US": "TTM 시행"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TTM 시행"
            },
            "synonyms": "Clinic",
            "order": 1,
            "groupTermId": {
                "name": "ttm",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "no"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "yes"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "target_temp",
            "displayName": {
                "en_US": "target temperature"
            },
            "definition": {
                "en_US": "target temperature"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "target temperature"
            },
            "synonyms": "Clinic",
            "order": 2,
            "groupTermId": {
                "name": "ttm",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "unit": "℃",
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Date",
            "termName": "ttm_start_date",
            "displayName": {
                "en_US": "start date"
            },
            "definition": {
                "en_US": "start date"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "start date"
            },
            "synonyms": "Clinic",
            "order": 3,
            "groupTermId": {
                "name": "ttm",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "enableTime": true
        },
        {
            "termType": "Group",
            "termName": "rehabilitation_test_init",
            "displayName": {
                "en_US": "재활의학과 검사 [Initial] "
            },
            "definition": {
                "en_US": "재활의학과 검사 [Initial] "
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "재활의학과 검사 [Initial] "
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "rehabilitation_test_last",
            "displayName": {
                "en_US": "재활의학과 검사[last]"
            },
            "definition": {
                "en_US": "재활의학과 검사[last]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "재활의학과 검사[last]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Numeric",
            "termName": "mmse_init",
            "displayName": {
                "en_US": "MMSE(1st)"
            },
            "definition": {
                "en_US": "MMSE(1st)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MMSE(1st)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "rehabilitation_test_init",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "gds_init",
            "displayName": {
                "en_US": "GDS(1st)"
            },
            "definition": {
                "en_US": "GDS(1st)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "GDS(1st)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "rehabilitation_test_init",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "kmbi_init",
            "displayName": {
                "en_US": "KMBI(1st)"
            },
            "definition": {
                "en_US": "KMBI(1st)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "KMBI(1st)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "rehabilitation_test_init",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "mmse_last",
            "displayName": {
                "en_US": "MMSE(last)"
            },
            "definition": {
                "en_US": "MMSE(last)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MMSE(last)"
            },
            "synonyms": "Rehabilitation",
            "order": 1,
            "groupTermId": {
                "name": "rehabilitation_test_last",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "gds_last",
            "displayName": {
                "en_US": "GDS(last)"
            },
            "definition": {
                "en_US": "GDS(last)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "GDS(last)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "rehabilitation_test_last",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "kmbi_last",
            "displayName": {
                "en_US": "KMBI(last)"
            },
            "definition": {
                "en_US": "KMBI(last)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "KMBI(last)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "rehabilitation_test_last",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Group",
            "termName": "reh_opd_1st",
            "displayName": {
                "en_US": "재활의학과 검사 [REH OPD FU_1st]"
            },
            "definition": {
                "en_US": "재활의학과 검사 [REH OPD FU_1st]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "재활의학과 검사 [REH OPD FU_1st]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Numeric",
            "termName": "mmse_1st",
            "displayName": {
                "en_US": "MMSE(1st)"
            },
            "definition": {
                "en_US": "MMSE(1st)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MMSE(1st)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "reh_opd_1st",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "gds_1st",
            "displayName": {
                "en_US": "GDS(1st)"
            },
            "definition": {
                "en_US": "GDS(1st)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "GDS(1st)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "reh_opd_1st",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "kmbi_1st",
            "displayName": {
                "en_US": "KMBI(1st)"
            },
            "definition": {
                "en_US": "KMBI(1st)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "KMBI(1st)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "reh_opd_1st",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Group",
            "termName": "reh_opd_2nd",
            "displayName": {
                "en_US": "재활의학과 검사 [REH OPD FU_2nd]"
            },
            "definition": {
                "en_US": "재활의학과 검사 [REH OPD FU_2nd]"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "재활의학과 검사 [REH OPD FU_2nd]"
            },
            "synonyms": "Rehabilitation Test",
            "order": 4,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Numeric",
            "termName": "mmse_2nd",
            "displayName": {
                "en_US": "MMSE(last)"
            },
            "definition": {
                "en_US": "MMSE(last)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MMSE(last)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 1,
            "groupTermId": {
                "name": "reh_opd_2nd",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "gds_2nd",
            "displayName": {
                "en_US": "GDS(last)"
            },
            "definition": {
                "en_US": "GDS(last)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "GDS(last)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 2,
            "groupTermId": {
                "name": "reh_opd_2nd",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "인지장애 없음"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "매우 경미한 인지장애"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "경미한 인지장애"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "중증도의 인지장애"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "초기치매의 인지장애"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "중기치매의 인지장애"
                    }
                },
                {
                    "value": "7",
                    "labelMap": {
                        "en_US": "말기치매의 인지장애"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "kmbi_2nd",
            "displayName": {
                "en_US": "KMBI(last)"
            },
            "definition": {
                "en_US": "KMBI(last)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "KMBI(last)"
            },
            "synonyms": "Rehabilitation Test",
            "order": 3,
            "groupTermId": {
                "name": "reh_opd_2nd",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Group",
            "termName": "reh_opd_out",
            "displayName": {
                "en_US": "퇴원 후 REH OPD F/U"
            },
            "definition": {
                "en_US": "퇴원 후 REH OPD F/U"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 후 REH OPD F/U"
            },
            "synonyms": "Rehabilitation Test",
            "order": 6,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "neurologic_ae",
            "displayName": {
                "en_US": "퇴원 시  neurologic AE"
            },
            "definition": {
                "en_US": "퇴원 시  neurologic AE"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 시  neurologic AE"
            },
            "synonyms": "Rehabilitation Test",
            "order": 5,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "neurologic_tc",
            "displayName": {
                "en_US": "노출 후 신경학적 _ TC"
            },
            "definition": {
                "en_US": "노출 후 신경학적 _ TC"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "노출 후 신경학적 _ TC"
            },
            "synonyms": "Rehabilitation Test",
            "order": 7,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "neurologic_seq",
            "displayName": {
                "en_US": "Neurologic sequelae"
            },
            "definition": {
                "en_US": "Neurologic sequelae"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Neurologic sequelae"
            },
            "synonyms": "Rehabilitation Test",
            "order": 8,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "mem_think_test",
            "displayName": {
                "en_US": "기억/사고력 검사"
            },
            "definition": {
                "en_US": "Memory and Thinking Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Rehabilitation Test",
            "order": 10,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "trail_making",
            "displayName": {
                "en_US": "Trail making"
            },
            "definition": {
                "en_US": "Trail making"
            },
            "abstractKey": false,
            "searchable": true,
            "order": 9,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "stroop_test",
            "displayName": {
                "en_US": "스트룹검사[Word_Color_Seconds]"
            },
            "definition": {
                "en_US": "스트룹검사[Word_Color_Seconds]"
            },
            "abstractKey": false,
            "searchable": true,
            "order": 11,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "stroop_test_error",
            "displayName": {
                "en_US": "스트룹검사[Word_Color_Errors]"
            },
            "definition": {
                "en_US": "스트룹검사[Word_Color_Errors]"
            },
            "abstractKey": false,
            "searchable": true,
            "order": 12,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "reh_opd_test",
            "displayName": {
                "en_US": "재활의학과/작업치료실 검사"
            },
            "definition": {
                "en_US": "Rehabilitation, Occupational Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Rehabilitation Test",
            "order": 13,
            "groupTermId": {
                "name": "rehabilitation_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "molecular_biology_test",
            "displayName": {
                "en_US": "분자생물검사"
            },
            "definition": {
                "en_US": "Molecular Biology Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 1,
            "groupTermId": {
                "name": "total_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "ap_protein_e4",
            "displayName": {
                "en_US": "Apolipo protein E4"
            },
            "definition": {
                "en_US": "Apolipo protein E4"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 1,
            "groupTermId": {
                "name": "molecular_biology_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "E2/E2"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "E2/E3"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "E2/E4"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "E3/E3"
                    }
                },
                {
                    "value": "5",
                    "labelMap": {
                        "en_US": "E3/E4"
                    }
                },
                {
                    "value": "6",
                    "labelMap": {
                        "en_US": "E4/E4"
                    }
                }
            ]
        },
        {
            "termType": "Group",
            "termName": "arterial_test",
            "displayName": {
                "en_US": "동맥혈검사"
            },
            "definition": {
                "en_US": "Arterial Blood Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 2,
            "groupTermId": {
                "name": "total_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "chem_test",
            "displayName": {
                "en_US": "화학검사"
            },
            "definition": {
                "en_US": "Chemical Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 3,
            "groupTermId": {
                "name": "total_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "heart_test",
            "displayName": {
                "en_US": "심근경색/심부전검사"
            },
            "definition": {
                "en_US": "Myocardial Infarction/Cardiac Insufficiency Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 4,
            "groupTermId": {
                "name": "total_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "imm_test",
            "displayName": {
                "en_US": "호르몬/종양/자가면역검사"
            },
            "definition": {
                "en_US": "Hormone/Tumpor/Autoimmunity Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 5,
            "groupTermId": {
                "name": "total_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "blood_test",
            "displayName": {
                "en_US": "혈액검사"
            },
            "definition": {
                "en_US": "Blood Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 6,
            "groupTermId": {
                "name": "total_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "throm_test",
            "displayName": {
                "en_US": "응고/출혈/혈전검사"
            },
            "definition": {
                "en_US": "Blood coagulation/Bleeding/Thrombus Test"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Total Test",
            "order": 7,
            "groupTermId": {
                "name": "total_test",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "init_ecg",
            "displayName": {
                "en_US": "Initial ECG"
            },
            "definition": {
                "en_US": "Initial ECG"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Image Examination",
            "order": 1,
            "groupTermId": {
                "name": "image_exam",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "mr_brain",
            "displayName": {
                "en_US": "MR brain"
            },
            "definition": {
                "en_US": "MR brain"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Image Examination",
            "order": 2,
            "groupTermId": {
                "name": "image_exam",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "cardiac_study",
            "displayName": {
                "en_US": "Cardiac study"
            },
            "definition": {
                "en_US": "Cardiac study"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Image Examination",
            "order": 3,
            "groupTermId": {
                "name": "image_exam",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Group",
            "termName": "tte_study",
            "displayName": {
                "en_US": "TTE study"
            },
            "definition": {
                "en_US": "TTE study"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Image Examination",
            "order": 4,
            "groupTermId": {
                "name": "image_exam",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "ecg_rate",
            "displayName": {
                "en_US": "Rate"
            },
            "definition": {
                "en_US": "Rate"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Rate"
            },
            "synonyms": "Image Examination",
            "order": 1,
            "groupTermId": {
                "name": "init_ecg",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "NSR"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Tachycardia"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "Bradycardia"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "기타"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "qtc_time",
            "displayName": {
                "en_US": "QTc time(ms)"
            },
            "definition": {
                "en_US": "QTc time(ms)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "QTc time(ms)"
            },
            "synonyms": "Image Examination",
            "order": 2,
            "groupTermId": {
                "name": "init_ecg",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "st_t_abnormal",
            "displayName": {
                "en_US": "ST-T 이상"
            },
            "definition": {
                "en_US": "ST-T 이상"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "ST-T 이상"
            },
            "synonyms": "Image Examination",
            "order": 3,
            "groupTermId": {
                "name": "init_ecg",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "ecg_comment",
            "displayName": {
                "en_US": "기타특이소견"
            },
            "definition": {
                "en_US": "기타특이소견"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "기타특이소견"
            },
            "synonyms": "Image Examination",
            "order": 4,
            "groupTermId": {
                "name": "init_ecg",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "mri_brain_bool",
            "displayName": {
                "en_US": "MRI brain"
            },
            "definition": {
                "en_US": "MRI brain"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MRI brain"
            },
            "synonyms": "Image Examination",
            "order": 1,
            "groupTermId": {
                "name": "mr_brain",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "Date",
            "termName": "mr_date",
            "displayName": {
                "en_US": "MR 시행 날짜"
            },
            "definition": {
                "en_US": "MR 시행 날짜"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MR 시행 날짜"
            },
            "synonyms": "Image Examination",
            "order": 2,
            "groupTermId": {
                "name": "mr_brain",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "String",
            "termName": "mr_comment",
            "displayName": {
                "en_US": "MR 공식판독"
            },
            "definition": {
                "en_US": "MR 공식판독"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "MR 공식판독"
            },
            "synonyms": "Image Examination",
            "order": 3,
            "groupTermId": {
                "name": "mr_brain",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "String",
            "termName": "ac_lesion_comment",
            "displayName": {
                "en_US": "Ac lesion on DWI"
            },
            "definition": {
                "en_US": "Ac lesion on DWI"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Ac lesion on DWI"
            },
            "synonyms": "Image Examination",
            "order": 4,
            "groupTermId": {
                "name": "mr_brain",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "fu_mr_brain_bool",
            "displayName": {
                "en_US": "FU MR Brain"
            },
            "definition": {
                "en_US": "FU MR Brain"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "FU MR Brain"
            },
            "synonyms": "Image Examination",
            "order": 5,
            "groupTermId": {
                "name": "mr_brain",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "fu_mr_comment",
            "displayName": {
                "en_US": "FU MR 공식판독"
            },
            "definition": {
                "en_US": "FU MR 공식판독"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "FU MR 공식판독"
            },
            "synonyms": "Image Examination",
            "order": 6,
            "groupTermId": {
                "name": "mr_brain",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "Date",
            "termName": "fu_mr_date",
            "displayName": {
                "en_US": "FU MR 날짜"
            },
            "definition": {
                "en_US": "FU MR 날짜 "
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "FU MR 날짜 "
            },
            "synonyms": "Image Examination",
            "order": 7,
            "groupTermId": {
                "name": "mr_brain",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "cardiac_mri",
            "displayName": {
                "en_US": "Cardiac MRI"
            },
            "definition": {
                "en_US": "Cardiac MRI"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Cardiac MRI"
            },
            "synonyms": "Image Examination",
            "order": 1,
            "groupTermId": {
                "name": "cardiac_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "Date",
            "termName": "cardiac_mri_date",
            "displayName": {
                "en_US": "시행날짜"
            },
            "definition": {
                "en_US": "시행날짜"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "시행날짜"
            },
            "synonyms": "Image Examination",
            "order": 2,
            "groupTermId": {
                "name": "cardiac_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Date",
            "termName": "cardiac_mri_comment_date",
            "displayName": {
                "en_US": "판독결과 from 01 Aug 2017"
            },
            "definition": {
                "en_US": "판독결과 from 01 Aug 2017"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "판독결과 from 01 Aug 2017"
            },
            "synonyms": "Image Examination",
            "order": 3,
            "groupTermId": {
                "name": "cardiac_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "t1_t2_mapping",
            "displayName": {
                "en_US": "T1/T2 maping"
            },
            "definition": {
                "en_US": "T1/T2 maping"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "T1/T2 maping"
            },
            "synonyms": "Image Examination",
            "order": 4,
            "groupTermId": {
                "name": "cardiac_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "coronary_bool",
            "displayName": {
                "en_US": "Coronary 평가"
            },
            "definition": {
                "en_US": "Coronary 평가"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Coronary 평가"
            },
            "synonyms": "Image Examination",
            "order": 5,
            "groupTermId": {
                "name": "cardiac_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "cardiac CT"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "coronary angiography"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "coronary_comment",
            "displayName": {
                "en_US": "판독결과"
            },
            "definition": {
                "en_US": "판독결과"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "판독결과"
            },
            "synonyms": "Image Examination",
            "order": 6,
            "groupTermId": {
                "name": "cardiac_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "tte_em",
            "displayName": {
                "en_US": "TTE by EM"
            },
            "definition": {
                "en_US": "TTE by EM"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TTE by EM"
            },
            "synonyms": "Image Examination",
            "order": 1,
            "groupTermId": {
                "name": "tte_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "tte_em_pre_hbo",
            "displayName": {
                "en_US": "TTE by EM pre HBO"
            },
            "definition": {
                "en_US": "TTE by EM pre HBO"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TTE by EM pre HBO"
            },
            "synonyms": "Image Examination",
            "order": 2,
            "groupTermId": {
                "name": "tte_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tte_em_after_hbo",
            "displayName": {
                "en_US": "2021-07-15부터 TTE by EM after HBO"
            },
            "definition": {
                "en_US": "2021-07-15부터 TTE by EM after HBO"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "2021-07-15부터 TTE by EM after HBO"
            },
            "synonyms": "Image Examination",
            "order": 3,
            "groupTermId": {
                "name": "tte_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "tte_car",
            "displayName": {
                "en_US": "TTE by CAR"
            },
            "definition": {
                "en_US": "TTE by CAR"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "TTE by CAR"
            },
            "synonyms": "Image Examination",
            "order": 4,
            "groupTermId": {
                "name": "tte_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Date",
            "termName": "car_tte_reading",
            "displayName": {
                "en_US": "CAR TTE reading"
            },
            "definition": {
                "en_US": "CAR TTE reading"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CAR TTE reading"
            },
            "synonyms": "Image Examination",
            "order": 5,
            "groupTermId": {
                "name": "tte_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "enableTime": true
        },
        {
            "termType": "List",
            "termName": "cardiomyopathy",
            "displayName": {
                "en_US": "cardiomyopathy"
            },
            "definition": {
                "en_US": "cardiomyopathy"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "cardiomyopathy"
            },
            "synonyms": "Image Examination",
            "order": 6,
            "groupTermId": {
                "name": "tte_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "scmp",
            "displayName": {
                "en_US": "SCMP"
            },
            "definition": {
                "en_US": "SCMP"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "SCMP"
            },
            "synonyms": "Image Examination",
            "order": 7,
            "groupTermId": {
                "name": "tte_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "global_dysfuction",
            "displayName": {
                "en_US": "Global dysfunction"
            },
            "definition": {
                "en_US": "Global dysfunction"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Global dysfunction"
            },
            "synonyms": "Image Examination",
            "order": 8,
            "groupTermId": {
                "name": "tte_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "cardiovascular_out",
            "displayName": {
                "en_US": "퇴원 후 Cardiovascular disease"
            },
            "definition": {
                "en_US": "퇴원 후 Cardiovascular disease"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 후 Cardiovascular disease"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 1,
            "groupTermId": {
                "name": "ae_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "String",
            "termName": "stroke_out",
            "displayName": {
                "en_US": "퇴원 후 Stroke disease"
            },
            "definition": {
                "en_US": "퇴원 후 Stroke disease"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 후 Stroke disease"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 2,
            "groupTermId": {
                "name": "ae_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "Date",
            "termName": "reserve_date_out",
            "displayName": {
                "en_US": "예약날짜"
            },
            "definition": {
                "en_US": "예약날짜"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "예약날짜"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 1,
            "groupTermId": {
                "name": "cardiology_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "visit_bool_out",
            "displayName": {
                "en_US": "방문 여부"
            },
            "definition": {
                "en_US": "방문 여부"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "방문 여부"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 2,
            "groupTermId": {
                "name": "cardiology_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "echocardiography_bool",
            "displayName": {
                "en_US": "심장초음파 시행"
            },
            "definition": {
                "en_US": "심장초음파 시행"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "심장초음파 시행"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 1,
            "groupTermId": {
                "name": "echocardiography_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "Date",
            "termName": "echocardiography_date",
            "displayName": {
                "en_US": "시행날짜"
            },
            "definition": {
                "en_US": "시행날짜"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "시행날짜"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 2,
            "groupTermId": {
                "name": "echocardiography_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "enableTime": true
        },
        {
            "termType": "String",
            "termName": "echocardiography_comment",
            "displayName": {
                "en_US": "판독결과"
            },
            "definition": {
                "en_US": "판독결과"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "판독결과"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 3,
            "groupTermId": {
                "name": "echocardiography_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "List",
            "termName": "echocardiography_place",
            "displayName": {
                "en_US": "시행장소"
            },
            "definition": {
                "en_US": "시행장소"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "시행장소"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 4,
            "groupTermId": {
                "name": "echocardiography_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "CAR OPD"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "CAR adm"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "other OPD"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "other adm"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "out_pass_1year",
            "displayName": {
                "en_US": "퇴원 후 1년 이내 "
            },
            "definition": {
                "en_US": "퇴원 후 1년 이내 "
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 후 1년 이내 "
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 1,
            "groupTermId": {
                "name": "passing_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "unknown"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "out_pass_after_1year",
            "displayName": {
                "en_US": "퇴원 1년 이후"
            },
            "definition": {
                "en_US": "퇴원 1년 이후"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "퇴원 1년 이후"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 2,
            "groupTermId": {
                "name": "passing_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "unknown"
                    }
                }
            ]
        },
        {
            "termType": "Date",
            "termName": "death_time",
            "displayName": {
                "en_US": "time of death"
            },
            "definition": {
                "en_US": "time of death"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "time of death"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 3,
            "groupTermId": {
                "name": "passing_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "String",
            "termName": "death_cause",
            "displayName": {
                "en_US": "cause of death"
            },
            "definition": {
                "en_US": "cause of death"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "cause of death"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 4,
            "groupTermId": {
                "name": "passing_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            },
            "maxLength": "1024",
            "multipleLine": true
        },
        {
            "termType": "Date",
            "termName": "contact_date_out",
            "displayName": {
                "en_US": "contact date"
            },
            "definition": {
                "en_US": "contact date"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "contact date"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 5,
            "groupTermId": {
                "name": "passing_out",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "List",
            "termName": "neurologic_complications",
            "displayName": {
                "en_US": "신경학적 합병증 여부"
            },
            "definition": {
                "en_US": "신경학적 합병증 여부"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "신경학적 합병증 여부"
            },
            "synonyms": "Abnormal Reaction after discharged",
            "order": 1,
            "groupTermId": {
                "name": "final_neurologic",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "신경학적 합병증 없음"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "합병증 후 회복"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "DNS"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "급성기 후 회복 안됨"
                    }
                }
            ]
        },
        {
            "termType": "Group",
            "termName": "co_aki",
            "displayName": {
                "en_US": "CO_AKI"
            },
            "definition": {
                "en_US": "CO_AKI"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "CO_AKI"
            },
            "synonyms": "Nephrology study",
            "order": 1,
            "groupTermId": {
                "name": "nephrology_study",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        },
        {
            "termType": "Numeric",
            "termName": "bt",
            "displayName": {
                "en_US": "BT"
            },
            "definition": {
                "en_US": "Body Temperature"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Body Temperature"
            },
            "synonyms": "ER Initial Evaluation",
            "order": 5,
            "groupTermId": {
                "name": "vs_hp",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "co_aki_arteriopressor",
            "displayName": {
                "en_US": "승압제"
            },
            "definition": {
                "en_US": "승압제"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "승압제"
            },
            "synonyms": "Nephrology study",
            "order": 2,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "NE(norepinephrine)"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "VP(vasopressin)"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "DB(dobutamine) "
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "co_aki_shock",
            "displayName": {
                "en_US": "Shock"
            },
            "definition": {
                "en_US": "Shock"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Shock"
            },
            "synonyms": "Nephrology study",
            "order": 1,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "co_aki_aki",
            "displayName": {
                "en_US": "AKI"
            },
            "definition": {
                "en_US": "AKI"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "AKI"
            },
            "synonyms": "Nephrology study",
            "order": 3,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "classification_of_aki",
            "displayName": {
                "en_US": "Classification of AKI"
            },
            "definition": {
                "en_US": "Classification of AKI"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Classification of AKI"
            },
            "order": 4,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "Not AKI"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "KDIGO 1"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "KDIGO 2"
                    }
                },
                {
                    "value": "3",
                    "labelMap": {
                        "en_US": "KDIGO 3"
                    }
                },
                {
                    "value": "4",
                    "labelMap": {
                        "en_US": "f/u loss"
                    }
                },
                {
                    "value": "9",
                    "labelMap": {
                        "en_US": "Unknown"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "progression_to_ckd",
            "displayName": {
                "en_US": "Progression to CKD"
            },
            "definition": {
                "en_US": "Progression to CKD"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Progression to CKD"
            },
            "order": 5,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                },
                {
                    "value": "9",
                    "labelMap": {
                        "en_US": "Unknown"
                    }
                }
            ]
        },
        {
            "termType": "Numeric",
            "termName": "base_line_cr",
            "displayName": {
                "en_US": "Base line Cr"
            },
            "definition": {
                "en_US": "Base line Cr"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Base line Cr"
            },
            "order": 6,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "Numeric",
            "termName": "peak_cr",
            "displayName": {
                "en_US": "Peak Cr"
            },
            "definition": {
                "en_US": "Peak Cr"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Peak Cr"
            },
            "order": 7,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "placeHolder": {
                "en_US": "미시행"
            }
        },
        {
            "termType": "List",
            "termName": "rrt",
            "displayName": {
                "en_US": "RRT"
            },
            "definition": {
                "en_US": "RRT"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "RRT"
            },
            "order": 8,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "HD"
                    }
                },
                {
                    "value": "2",
                    "labelMap": {
                        "en_US": "CRRT"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "iv_contrast_ct",
            "displayName": {
                "en_US": "IV Contrast (CT)"
            },
            "definition": {
                "en_US": "IV Contrast (CT)"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "IV Contrast (CT)"
            },
            "order": 9,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "nsaids",
            "displayName": {
                "en_US": "NSAIDs"
            },
            "definition": {
                "en_US": "NSAIDs"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "NSAIDs"
            },
            "order": 10,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "vancomycin",
            "displayName": {
                "en_US": "Vancomycin"
            },
            "definition": {
                "en_US": "Vancomycin"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Vancomycin"
            },
            "order": 11,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "teicoplenin",
            "displayName": {
                "en_US": "Teicoplenin"
            },
            "definition": {
                "en_US": "Teicoplenin"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Teicoplenin"
            },
            "order": 12,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "colistin",
            "displayName": {
                "en_US": "Colistin"
            },
            "definition": {
                "en_US": "Colistin"
            },
            "abstractKey": false,
            "searchable": true,
            "synonyms": "Colistin",
            "order": 13,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "bpshock",
            "displayName": {
                "en_US": "BP shock"
            },
            "definition": {
                "en_US": "BP shock"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "BP shock"
            },
            "order": 14,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "List",
            "termName": "inotropics",
            "displayName": {
                "en_US": "Inotropics"
            },
            "definition": {
                "en_US": "Inotropics"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Inotropics"
            },
            "order": 15,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1,
            "displayStyle": "select",
            "options": [
                {
                    "value": "미시행",
                    "labelMap": {
                        "en_US": "미시행"
                    }
                },
                {
                    "value": "0",
                    "labelMap": {
                        "en_US": "No"
                    }
                },
                {
                    "value": "1",
                    "labelMap": {
                        "en_US": "Yes"
                    }
                }
            ]
        },
        {
            "termType": "String",
            "termName": "aki_others",
            "displayName": {
                "en_US": "Others"
            },
            "definition": {
                "en_US": "Others"
            },
            "abstractKey": false,
            "searchable": true,
            "tooltip": {
                "en_US": "Others"
            },
            "order": 16,
            "groupTermId": {
                "name": "co_aki",
                "version": "1.0.0"
            },
            "status": 2,
            "state": -1
        }
    ]
};