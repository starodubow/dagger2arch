## dagger2arch
Variant of distribution of dependencies of a multi-module application using dagger2

В данном проекте приведен пример построения схемы распространения общих зависимостей в многомодульном проекте с использованием Dagger2.

## Краткая информация
Все компоненты имеют 2 интерфейса: 
- `...Dependencies` описывает внешние зависимости, необходимые для компонента.
- `...Api` описывает зависимости, которые компонент отдает наружу

## Описание градл модулей:

# `:core:app_context`
Модуль, проксирующий `application context` для нужд других модулей. Инициализируется на старте приложения в `MainApplication` классе. Получает на вход `application context`, Наружу отдает зависимость `application context`. Этот модуль необходим для того, чтобы другие модули могли получить application context из app модуля. Инициализируется во время первого обращения.
Компонент - `ApplicationContextComponent`

Также приведен ComponentHolder для хранения компонента.


# `:core:data`
Модуль с общей для проекта моделью `UserData`. Инициализируется во время первого обращения. На вход получает `application context` от `ApplicationContextComponent`. Наружу отдает зависимость `UserData`. Инициализируется во время первого обращения.
Компонент - `CoreDataComponent`

# `:core:network`
Модуль с общим для проекта сетевым слоем. На вход получает `application context` от `ApplicationContextComponent` и `UserData` от `CoreDataComponent`. Наружу отдает `BaseApiRouter` и `Retrofit.Builder`. Инициализируется во время первого обращения.
Компонент - 'CoreNetworkComponent'

# `:feature:profile`
Модуль профиля. На вход получает `UserData` от `CoreDataComponent` и `Retrofit.Builder` от `CoreNetworkComponent`. 
Компонент - 'FeatureProfileComponent'

# `:app`
Стандартный `app` модуль приложения. На входи получает `UserData` от `CoreDataComponent`. Создается в MainApplication умышленно, так как чаще всего именно так и инициализируются app компоненты. В результаты выноса всех общих зависимостей из app компонента, он может превратиться в фичевый компонент.
Компонент - `AppComponent`


## Мысли

# Что не нравится 
Способ резолва зависимостей. При росте количестве зависимостей, анонимный объект с зависимостями будет сильно разрастаться boilerplate кодом. Пока ничего умнее не придумал.
