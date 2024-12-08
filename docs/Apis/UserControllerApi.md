# UserControllerApi

All URIs are relative to *http://localhost:9777*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**delete**](UserControllerApi.md#delete) | **DELETE** /api/v1/user/{id} |  |
| [**showAll**](UserControllerApi.md#showAll) | **GET** /api/v1/users |  |
| [**showAllByUserRole**](UserControllerApi.md#showAllByUserRole) | **GET** /api/v1/users/role/{role} |  |
| [**showById**](UserControllerApi.md#showById) | **GET** /api/v1/user/{id} |  |
| [**update**](UserControllerApi.md#update) | **PATCH** /api/v1/user |  |


<a name="delete"></a>
# **delete**
> Object delete(id)



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

<a name="showAll"></a>
# **showAll**
> Object showAll()



### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="showAllByUserRole"></a>
# **showAllByUserRole**
> Object showAllByUserRole(role)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **role** | **Integer**| Role of the user: 0 &#x3D; Patient, 1 &#x3D; Doctor | [default to null] |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="showById"></a>
# **showById**
> Object showById(id)



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

<a name="update"></a>
# **update**
> Object update(UserDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **UserDTO** | [**UserDTO**](../Models/UserDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

