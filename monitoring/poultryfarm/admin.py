from django.contrib import admin
from .models import *
# Register your models here.

class TemperatureAdmin(admin.ModelAdmin):
    list_display = ('guid', 'types','meaning','time_action')
    list_display_links = ('guid', 'types','meaning','time_action')
    search_fields = ('guid', 'types','meaning','time_action')


class HumidityAdmin(admin.ModelAdmin):
    list_display = ('guid', 'types','meaning','time_action')
    list_display_links = ('guid', 'types','meaning','time_action')
    search_fields = ('guid', 'types','meaning','time_action')

class AmmoniaAdmin(admin.ModelAdmin):
    list_display = ('guid', 'types','meaning','time_action')
    list_display_links = ('guid', 'types','meaning','time_action')
    search_fields = ('guid', 'types','meaning','time_action')


class DioxideAdmin(admin.ModelAdmin):
    list_display = ('guid', 'types','meaning','time_action')
    list_display_links = ('guid', 'types','meaning','time_action')
    search_fields = ('guid', 'types','meaning','time_action')

admin.site.register(Temperature)
admin.site.register(Humidity)
admin.site.register(Ammonia)
admin.site.register(Dioxide)