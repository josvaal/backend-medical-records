# PrescriptionControllerApi

All URIs are relative to *http://localhost:9777*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create**](PrescriptionControllerApi.md#create) | **POST** /api/v1/prescription |  |
| [**delete1**](PrescriptionControllerApi.md#delete1) | **DELETE** /api/v1/prescription/{id} |  |
| [**showAll1**](PrescriptionControllerApi.md#showAll1) | **GET** /api/v1/prescriptions |  |
| [**showAllByMedicalHistoryId**](PrescriptionControllerApi.md#showAllByMedicalHistoryId) | **GET** /api/v1/prescriptions/medical_history/{id} |  |
| [**showById1**](PrescriptionControllerApi.md#showById1) | **GET** /api/v1/prescription/{id} |  |
| [**update1**](PrescriptionControllerApi.md#update1) | **PATCH** /api/v1/prescription |  |


<a name="create"></a>
# **create**
> Object create(PrescriptionDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **PrescriptionDTO** | [**PrescriptionDTO**](../Models/PrescriptionDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="delete1"></a>
# **delete1**
> Object delete1(id)



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

<a name="showAll1"></a>
# **showAll1**
> Object showAll1()



### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="showAllByMedicalHistoryId"></a>
# **showAllByMedicalHistoryId**
> Object showAllByMedicalHistoryId(id)



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

<a name="showById1"></a>
# **showById1**
> Object showById1(id)



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

<a name="update1"></a>
# **update1**
> Object update1(PrescriptionDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **PrescriptionDTO** | [**PrescriptionDTO**](../Models/PrescriptionDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

