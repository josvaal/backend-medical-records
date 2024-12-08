# Documentation for OpenAPI definition

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost:9777*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *AppointmentControllerApi* | [**create2**](./docs/Apis/AppointmentControllerApi.md#create2) | **POST** /api/v1/appointment |  |
*AppointmentControllerApi* | [**delete3**](./docs/Apis/AppointmentControllerApi.md#delete3) | **DELETE** /api/v1/appointment/{id} |  |
*AppointmentControllerApi* | [**showAll3**](./docs/Apis/AppointmentControllerApi.md#showall3) | **GET** /api/v1/appointments |  |
*AppointmentControllerApi* | [**showAllByDoctorId1**](./docs/Apis/AppointmentControllerApi.md#showallbydoctorid1) | **GET** /api/v1/appointments/doctor/{id} |  |
*AppointmentControllerApi* | [**showAllByPatientId1**](./docs/Apis/AppointmentControllerApi.md#showallbypatientid1) | **GET** /api/v1/appointments/patient/{id} |  |
*AppointmentControllerApi* | [**showById3**](./docs/Apis/AppointmentControllerApi.md#showbyid3) | **GET** /api/v1/appointment/{id} |  |
*AppointmentControllerApi* | [**update3**](./docs/Apis/AppointmentControllerApi.md#update3) | **PATCH** /api/v1/appointment |  |
| *AuthControllerApi* | [**login**](./docs/Apis/AuthControllerApi.md#login) | **POST** /api/v1/auth/login |  |
*AuthControllerApi* | [**profile**](./docs/Apis/AuthControllerApi.md#profile) | **GET** /api/v1/auth/profile |  |
*AuthControllerApi* | [**register**](./docs/Apis/AuthControllerApi.md#register) | **POST** /api/v1/auth/register |  |
| *MedicalHistoryControllerApi* | [**create1**](./docs/Apis/MedicalHistoryControllerApi.md#create1) | **POST** /api/v1/medical_history |  |
*MedicalHistoryControllerApi* | [**delete2**](./docs/Apis/MedicalHistoryControllerApi.md#delete2) | **DELETE** /api/v1/medical_history/{id} |  |
*MedicalHistoryControllerApi* | [**showAll2**](./docs/Apis/MedicalHistoryControllerApi.md#showall2) | **GET** /api/v1/medical_histories |  |
*MedicalHistoryControllerApi* | [**showAllByDoctorId**](./docs/Apis/MedicalHistoryControllerApi.md#showallbydoctorid) | **GET** /api/v1/medical_histories/doctor/{id} |  |
*MedicalHistoryControllerApi* | [**showAllByPatientId**](./docs/Apis/MedicalHistoryControllerApi.md#showallbypatientid) | **GET** /api/v1/medical_histories/patient/{id} |  |
*MedicalHistoryControllerApi* | [**showById2**](./docs/Apis/MedicalHistoryControllerApi.md#showbyid2) | **GET** /api/v1/medical_history/{id} |  |
*MedicalHistoryControllerApi* | [**update2**](./docs/Apis/MedicalHistoryControllerApi.md#update2) | **PATCH** /api/v1/medical_history |  |
| *PrescriptionControllerApi* | [**create**](./docs/Apis/PrescriptionControllerApi.md#create) | **POST** /api/v1/prescription |  |
*PrescriptionControllerApi* | [**delete1**](./docs/Apis/PrescriptionControllerApi.md#delete1) | **DELETE** /api/v1/prescription/{id} |  |
*PrescriptionControllerApi* | [**showAll1**](./docs/Apis/PrescriptionControllerApi.md#showall1) | **GET** /api/v1/prescriptions |  |
*PrescriptionControllerApi* | [**showAllByMedicalHistoryId**](./docs/Apis/PrescriptionControllerApi.md#showallbymedicalhistoryid) | **GET** /api/v1/prescriptions/medical_history/{id} |  |
*PrescriptionControllerApi* | [**showById1**](./docs/Apis/PrescriptionControllerApi.md#showbyid1) | **GET** /api/v1/prescription/{id} |  |
*PrescriptionControllerApi* | [**update1**](./docs/Apis/PrescriptionControllerApi.md#update1) | **PATCH** /api/v1/prescription |  |
| *UserControllerApi* | [**delete**](./docs/Apis/UserControllerApi.md#delete) | **DELETE** /api/v1/user/{id} |  |
*UserControllerApi* | [**showAll**](./docs/Apis/UserControllerApi.md#showall) | **GET** /api/v1/users |  |
*UserControllerApi* | [**showAllByUserRole**](./docs/Apis/UserControllerApi.md#showallbyuserrole) | **GET** /api/v1/users/role/{role} |  |
*UserControllerApi* | [**showById**](./docs/Apis/UserControllerApi.md#showbyid) | **GET** /api/v1/user/{id} |  |
*UserControllerApi* | [**update**](./docs/Apis/UserControllerApi.md#update) | **PATCH** /api/v1/user |  |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [AppointmentDTO](./docs/Models/AppointmentDTO.md)
 - [LoginDTO](./docs/Models/LoginDTO.md)
 - [MedicalHistoryDTO](./docs/Models/MedicalHistoryDTO.md)
 - [PrescriptionDTO](./docs/Models/PrescriptionDTO.md)
 - [RegisterDTO](./docs/Models/RegisterDTO.md)
 - [UserDTO](./docs/Models/UserDTO.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
