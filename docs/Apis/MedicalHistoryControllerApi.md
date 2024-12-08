# MedicalHistoryControllerApi

All URIs are relative to *http://localhost:9777*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create1**](MedicalHistoryControllerApi.md#create1) | **POST** /api/v1/medical_history |  |
| [**delete2**](MedicalHistoryControllerApi.md#delete2) | **DELETE** /api/v1/medical_history/{id} |  |
| [**showAll2**](MedicalHistoryControllerApi.md#showAll2) | **GET** /api/v1/medical_histories |  |
| [**showAllByDoctorId**](MedicalHistoryControllerApi.md#showAllByDoctorId) | **GET** /api/v1/medical_histories/doctor/{id} |  |
| [**showAllByPatientId**](MedicalHistoryControllerApi.md#showAllByPatientId) | **GET** /api/v1/medical_histories/patient/{id} |  |
| [**showById2**](MedicalHistoryControllerApi.md#showById2) | **GET** /api/v1/medical_history/{id} |  |
| [**update2**](MedicalHistoryControllerApi.md#update2) | **PATCH** /api/v1/medical_history |  |


<a name="create1"></a>
# **create1**
> Object create1(MedicalHistoryDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **MedicalHistoryDTO** | [**MedicalHistoryDTO**](../Models/MedicalHistoryDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="delete2"></a>
# **delete2**
> Object delete2(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="showAll2"></a>
# **showAll2**
> Object showAll2()



### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="showAllByDoctorId"></a>
# **showAllByDoctorId**
> Object showAllByDoctorId(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="showAllByPatientId"></a>
# **showAllByPatientId**
> Object showAllByPatientId(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="showById2"></a>
# **showById2**
> Object showById2(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="update2"></a>
# **update2**
> Object update2(MedicalHistoryDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **MedicalHistoryDTO** | [**MedicalHistoryDTO**](../Models/MedicalHistoryDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

