#from django.contrib.auth.models import User
from django.db import models


class Temperature(models.Model):
    guid = models.CharField(max_length=255)
    types = models.CharField(max_length=255)
    meaning = models.CharField(max_length=255)
    time_action = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.guid + ' ' + self.types


class Humidity(models.Model):
    guid = models.CharField(max_length=255)
    types = models.CharField(max_length=255)
    meaning = models.CharField(max_length=255)
    time_action = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.guid + ' ' + self.types


class Ammonia(models.Model):
    guid = models.CharField(max_length=255)
    types = models.CharField(max_length=255)
    meaning = models.CharField(max_length=255)
    time_action = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.guid + ' ' + self.types


class Dioxide(models.Model):
    guid = models.CharField(max_length=255)
    types = models.CharField(max_length=255)
    meaning = models.CharField(max_length=255)
    time_action = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.guid + ' ' + self.types

