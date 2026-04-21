# Project Definition

## 1. Problem
We need a system to manage the billing for a convenience store based on its daily sales records, with the goal of reducing calculation errors, improving customer service, and maintaining proper control over inventory and business revenue[cite: 13, 14].

## 2. Overview
In the context of managing a convenience store, daily sales operations generate critical information that must be organized and controlled efficiently[cite: 15, 16]. Customers expect fast and accurate service, while store managers require reliable records that reflect both transactions and inventory status[cite: 17]. When billing depends on manual calculations or poorly structured processes, the risk of errors increases, and proper revenue control becomes difficult[cite: 18]. Therefore, it is necessary to implement a system that integrates sales records into a clear and automated model[cite: 19].

## 3. Background
In a convenience store, each sales transaction involves not only the exchange of products for money but also the immediate update of inventory and the precise recording of revenue[cite: 20, 21]. The value of the store's stock is directly related to the quantity of products available and their unit price[cite: 22].

The revenue of a transaction can be expressed as:
\$\=(Q \cdot UP)-D+T\$\$ [cite: 26, 27]

Where Q is the quantity sold, UP the unit price, D the discounts applied, and T the corresponding taxes[cite: 28].

## 4. Analyst Comparison
The system represents real-world concepts, since it works with objects such as customer, product, and invoice[cite: 30, 31]. It uses inheritance to allow the creation of product or payment types from a base class[cite: 32]. At the same time, it practices polymorphism, making different payments or products behave differently with the same methods, and it applies encapsulation by enforcing rules such as not selling without stock[cite: 33, 34].
