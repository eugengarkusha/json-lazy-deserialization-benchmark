package model

import org.joda.time.DateTime
import play.api.libs.json.JsSuccess
import play.api.libs.json.Json

object eager {

  case class Customer(
    customerNumber: Option[String],
    dateOfBirth: Option[DateTime],
    firstName: Option[String],
    lastName: Option[String],
    accountCreated: Option[DateTime],
    email: Option[String]
  )

  case class Address(
    location: Option[Location],
    addressType: Option[String],
    addressSuffix: Option[String],
    firstName: Option[String],
    lastName: Option[String],
    fullName: Option[String],
    parcelShop: Option[Boolean],
    street: Option[String],
    houseNumber: Option[String],
    city: Option[String],
    country: Option[String],
    postalCode: Option[String]
  )

  case class Order(
    created: Option[DateTime],
    orderOrigin: Option[String]
  )

  case class Location(
    lat: Double,
    lon: Double
  )

  case class PhoneNumber(
    phoneNumber: String,
    region: Option[String],
    location: Option[Location]
  )

  case class OrderItem(
    pricePerArticle: Double
  )

  case class DeviceInfo(
    exactId: Option[String],
    smartId: Option[String]
  )

  implicit val readsCustomer = Json.format[Customer]
  implicit val readsLocation = Json.format[Location]
  implicit val readsAddress = Json.format[Address]
  implicit val readsOrder = Json.format[Order]

  implicit val readsPhoneNumber = Json.format[PhoneNumber]
  implicit val readsOrderItem = Json.format[OrderItem]
  implicit val readsDeviceInfo = Json.format[DeviceInfo]
  implicit val readsModel = Json.format[Transaction]

  case class Transaction(
    id: String,
    accountId: String,
    eventTime: DateTime,
    customer: Customer,
    order: Order,
    addresses: List[Address],
    devices: List[DeviceInfo],
    orderItems: List[OrderItem],
    phoneNumbers: Option[List[PhoneNumber]]
  )

}
