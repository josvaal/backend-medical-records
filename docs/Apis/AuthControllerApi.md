# AuthControllerApi

All URIs are relative to *http://localhost:9777*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**login**](AuthControllerApi.md#login) | **POST** /api/v1/auth/login |  |
| [**profile**](AuthControllerApi.md#profile) | **GET** /api/v1/auth/profile |  |
| [**register**](AuthControllerApi.md#register) | **POST** /api/v1/auth/register |  |


<a name="login"></a>
# **login**
> Object login(LoginDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **LoginDTO** | [**LoginDTO**](../Models/LoginDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="profile"></a>
# **profile**
> Object profile()



### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="register"></a>
# **register**
> Object register(RegisterDTO)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **RegisterDTO** | [**RegisterDTO**](../Models/RegisterDTO.md)|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

