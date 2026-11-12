package com.example.kotlinwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String,
    val address: String
)

@Composable
fun ContactColumn() {
    Column {
        Text("Имя: Евгений")
        Text("Отчество: Андреевич")
        Text("Фамилия: Лукашин")
        Text("Мобильный телефон: +7 495 495 95 95")
        Text("Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12")
    }
}

@Preview(showBackground = true)
@Composable
fun ContactColumnPreview() {
    ContactColumn()
}

@Composable
fun ContactCard(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Имя: ${contact.name}", textAlign = TextAlign.Center)
        Text("Отчество: ${contact.patronymic}", textAlign = TextAlign.Center)
        Text("Фамилия: ${contact.surname}", textAlign = TextAlign.Center)
        Text("Мобильный телефон: ${contact.phone}", textAlign = TextAlign.Center)
        Text("Адрес: ${contact.address}", textAlign = TextAlign.Center)
    }
}

@Composable
fun ContactList() {
    val contacts = listOf(
        Contact(
            "Евгений", "Андреевич", "Лукашин",
            "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
        ),
        Contact(
            "Василий", "Егорович", "Кузякин",
            "—", "Ивановская область, дер. Крутово, д. 4"
        ),
        Contact(
            "Людмила", "Прокофьевна", "Калугина",
            "+7 495 788 78 78", "Москва, Большая Никитская, д. 43, кв. 290"
        )
    )

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        contacts.forEach { contact ->
            ContactCard(contact)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    ContactList()
}

@Composable
fun ContactRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Имя: Евгений", textAlign = TextAlign.Center)
            Text("Отчество: Андреевич", textAlign = TextAlign.Center)
            Text("Фамилия: Лукашин", textAlign = TextAlign.Center)
            Text("Мобильный телефон: +7 495 495 95 95", textAlign = TextAlign.Center)
            Text(
                "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                textAlign = TextAlign.Center
            )
        }
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactRowPreview() {
    ContactRow()
}