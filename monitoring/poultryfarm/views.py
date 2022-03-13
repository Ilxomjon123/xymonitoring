from datetime import date, timedelta
from rest_framework import viewsets, permissions
from poultryfarm.models import *
from .serializers import *


class TemperatureViewSet(viewsets.ModelViewSet):
    queryset = Temperature.objects.all()
    permissions_classes = [
        permissions.AllowAny
    ]
    serializer_class = TemperatureSerializer

def temp_page(request):
    current_date = date.today()
    tommorow_date = date.today() + timedelta(days=1)
    time.strftime('%Y-%m-%d')
    begin = request.POST.get('begin') if request.POST.get('begin') else current_date
    end = request.POST.get('end') if request.POST.get('end') else tommorow_date
    #print('begin',request.POST.get('begin'))
    return Temperature.objects.all().filter(time_action__range=(begin, end))

class HumidityViewSet(viewsets.ModelViewSet):
    queryset = Humidity.objects.all()
    permissions_classes = [
        permissions.AllowAny
    ]
    serializer_class = HumiditySerializer

def hum_page(request):
    current_date = date.today()
    tommorow_date = date.today() + timedelta(days=1)
    time.strftime('%Y-%m-%d')
    begin = request.POST.get('begin') if request.POST.get('begin') else current_date
    end = request.POST.get('end') if request.POST.get('end') else tommorow_date
    return Humidity.objects.all().filter(time_action__range=(begin, end))


class AmmoniaViewSet(viewsets.ModelViewSet):
    queryset = Ammonia.objects.all()
    permissions_classes = [
        permissions.AllowAny
    ]
    serializer_class = AmmoniaSerializer


def amm_page(request):
    current_date = date.today()
    tommorow_date = date.today() + timedelta(days=1)
    time.strftime('%Y-%m-%d')
    begin = request.POST.get('begin') if request.POST.get('begin') else current_date
    end = request.POST.get('end') if request.POST.get('end') else tommorow_date
    return Ammonia.objects.all().filter(time_action__range=(begin, end))


class DioxideViewSet(viewsets.ModelViewSet):
    queryset = Dioxide.objects.all()
    permissions_classes = [
        permissions.AllowAny
    ]
    serializer_class = DioxideSerializer


def Diox_page(request):
    current_date = date.today()
    tommorow_date = date.today() + timedelta(days=1)
    time.strftime('%Y-%m-%d')
    begin = request.POST.get('begin') if request.POST.get('begin') else current_date
    end = request.POST.get('end') if request.POST.get('end') else tommorow_date
    return Dioxide.objects.all().filter(time_action__range=(begin, end))


