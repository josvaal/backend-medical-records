# AppointmentControllerApi

All URIs are relative to *http://localhost:9777*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**create2**](AppointmentControllerApi.md#create2) | **POST** /api/v1/appointment |  |
| [**delete3**](AppointmentControllerApi.md#delete3) | **DELETE** /api/v1/appointment/{id} |  |
| [**showAll3**](AppointmentControllerApi.md#showAll3) | **GET** /api/v1/appointments |  |
| [**showAllByDoctorId1**](AppointmentControllerApi.md#showAllByDoctorId1) | **GET** /api/v1/appointments/doctor/{id} |  |
| [**showAllByPatientId1**](AppointmentControllerApi.md#showAllByPatientId1) | **GET** /api/v1/appointments/patient/{id} |  |
| [**showById3**](AppointmentControllerApi.md#showById3) | **GET** /api/v1/appointment/{id} |  |
| [**update3**](AppointmentControllerApi.md#update3) | **PATCH** /api/v1/appointment |  |


<a name="create2"></a>
# **create2**
> Object create2(AppointmentDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **AppointmentDTO** | [**AppointmentDTO**](../Models/AppointmentDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="delete3"></a>
# **delete3**
> Object delete3(id)



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

<a name="showAll3"></a>
# **showAll3**
> Object showAll3()



### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="showAllByDoctorId1"></a>
# **showAllByDoctorId1**
> Object showAllByDoctorId1(id)



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

<a name="showAllByPatientId1"></a>
# **showAllByPatientId1**
> Object showAllByPatientId1(id)



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

<a name="showById3"></a>
# **showById3**
> Object showById3(id)



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

<a name="update3"></a>
# **update3**
> Object update3(AppointmentDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **AppointmentDTO** | [**AppointmentDTO**](../Models/AppointmentDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

