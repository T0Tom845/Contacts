1) Программа имеет 2 профиля default и init, изначально выставлен init, чтобы изменить профель необходимо изменить application.properties строку spring.profiles.active= [init|default]
2) Основной bean - ContactsContainer, вызывается из класса Main через AnnotationConfig напрямую 
3) Профили:
   1) init - Инициализирует ContactsContainer включая контакты из файла contacts.txt
   2) default - Инициализирует пустое хранилище в ContactsContainer 
4) Методы для работы с ContactsContainer:
   1) printAllContacts() - выводит все хранящиеся контакты
   2) addContact(String|Contact contact) - добавляет контакт в хранилище, поддерживает ввод строкой и объектом контакта
   3) deleteByEmail(String email) - удаляет контакт из хранилища и из файла по email, в случае если контакта с таким email нет, выводит сообщение
   4) inputNewContact() - консольный ввод нового формата